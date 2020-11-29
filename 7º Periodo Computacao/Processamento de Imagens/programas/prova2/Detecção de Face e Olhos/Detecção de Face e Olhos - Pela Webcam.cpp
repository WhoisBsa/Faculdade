#include "opencv2/opencv.hpp"
#include "opencv2/objdetect.hpp" 
#include "opencv2/highgui.hpp" 
#include "opencv2/imgproc.hpp" 
#include <iostream> 

using namespace std;
using namespace cv;

//protótipo da função detectAndDraw
void detectAndDraw(Mat& img, CascadeClassifier& cascade, CascadeClassifier& nestedCascade, double scale);

string cascadeName, nestedCascadeName;

int main(int argc, const char** argv)
{
    //possibilita a detecção de face pela webcam
    VideoCapture capture;
    Mat frame, image;

    //Classificadores
    CascadeClassifier cascade, nestedCascade;
    double scale = 1;

    //Carrega o classificador de olhos
    nestedCascade.load("C:/opencv/sources/data/haarcascades/haarcascade_eye.xml");

    //Carrega o classificador de face
    cascade.load("C:/opencv/sources/data/haarcascades/haarcascade_frontalface_default.xml");

    //detecção de face e olhos pela webcam    
    capture.open(0);
    if (capture.isOpened())
    {
        //Captura o frame atual
        while (1)
        {
            capture >> frame;
            if (frame.empty())
                break;
            Mat frame1 = frame.clone();

            //faz a chamada da função de detecta e desenha na imagem
            detectAndDraw(frame1, cascade, nestedCascade, scale);

            char c = (char)waitKey(10);

            //teclas para encerrar a captura
            if (c == 27 || c == 'q' || c == 'Q')
                break;
        }
    }
    else
        cout << "Erro ao abrir a câmera";

    return 0;
}

void detectAndDraw(Mat& img, CascadeClassifier& cascade, CascadeClassifier& nestedCascade, double scale) {
    vector<Rect> faces, faces2;
    Mat gray, smallImg;

    //Converte para Grayscale
    cvtColor(img, gray, COLOR_BGR2GRAY);
    double fx = 1 / scale;

    //Redimensiona a imagem
    resize(gray, smallImg, Size(), fx, fx, INTER_LINEAR);
    equalizeHist(smallImg, smallImg);

    //detecta as faces utilizando o classificador
    cascade.detectMultiScale(smallImg, faces, 1.2, 5, 0 | CASCADE_SCALE_IMAGE, Size(30, 30));

    //desenha círculos nas faces
    for (size_t i = 0; i < faces.size(); i++)
    {
        Rect r = faces[i];
        Mat smallImgROI;
        vector<Rect> nestedObjects;
        Point center;
        //cor do círculo
        Scalar color = Scalar(255, 0, 0);
        int radius;

        double aspect_ratio = (double)r.width / r.height;
        if (0.75 < aspect_ratio && aspect_ratio < 1.3)
        {
            center.x = cvRound((r.x + r.width * 0.5) * scale);
            center.y = cvRound((r.y + r.height * 0.5) * scale);
            radius = cvRound((r.width + r.height) * 0.25 * scale);
            circle(img, center, radius, color, 3, 8, 0);
        }
        else
            rectangle(img, Point(cvRound(r.x * scale), cvRound(r.y * scale)),
                Point(cvRound((r.x + r.width - 1) * scale),
                    cvRound((r.y + r.height - 1) * scale)), color, 3, 8, 0);
        if (nestedCascade.empty())
            continue;

        smallImgROI = smallImg(r);

        //detecta os olhos nas faces
        nestedCascade.detectMultiScale(smallImgROI, nestedObjects, 1.2, 5,
            0 | CASCADE_SCALE_IMAGE, Size(30, 30));

        //desenha círculos nos olhos
        for (size_t j = 0; j < nestedObjects.size(); j++)
        {
            Rect nr = nestedObjects[j];
            center.x = cvRound((r.x + nr.x + nr.width * 0.5) * scale);
            center.y = cvRound((r.y + nr.y + nr.height * 0.5) * scale);
            radius = cvRound((nr.width + nr.height) * 0.25 * scale);
            circle(img, center, radius, Scalar(0, 255, 255), 3, 8, 0);
        }
    }

    //exibe a imagem com os circulos nas faces e nos olhos
    imshow("Imagem processada", img);
}
