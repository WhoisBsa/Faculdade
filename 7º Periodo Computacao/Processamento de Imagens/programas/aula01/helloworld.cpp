#include <opencv2/opencv.hpp>
#include <iostream>
 
using namespace cv;

int main( int argc, char** argv ) {
  Mat imagem, imagem_gray;

  // VideoCapture CvCapture("sample.mp4");

  // if (!CvCapture.isOpened())
  //   throw "Erro ao ler o arquivo de vídeo";

  // namedWindow("Vídeo", WINDOW_NORMAL);
  // resizeWindow("Vídeo", 854, 480);

  // for (;;) {
  //   Mat frame, gray;

  //   CvCapture >> frame;
  //   if (frame.empty())
  //     break;
  //   cvtColor(frame, gray, COLOR_BGR2GRAY);
  //   imshow("Vídeo", gray);
  //   // imshow("Vídeo", frame);
  //   waitKey(1);
  // }


  // imagem = imread("sample.png", IMREAD_COLOR);
  // imagem_gray = imread("sample.png", IMREAD_GRAYSCALE);


  // if (!imagem.data) {
  //   std::cout << "Erro ao abrir o endereço da imagem";
  //   return 1;
  // } else {
  //     imshow("sample.png", imagem);

  //     imshow("Foto em tons de cinza", imagem_gray);

  //     imwrite("imagemgray.jpg", imagem_gray);

  //   waitKey(0);

  //   return 0;
  // }

  VideoCapture CvCapture(0);

  if (!CvCapture.isOpened())
    throw "Erro ao ler o arquivo de vídeo";

  namedWindow("webcam", 1);

  namedWindow("webcam", WINDOW_NORMAL);
  resizeWindow("webcam", 854, 480);

  for (;;) {
    Mat frame;
    CvCapture >> frame;
    if (frame.empty()) 
      break;
    
    imshow("webcam", frame);
    waitKey(1);
  }
}