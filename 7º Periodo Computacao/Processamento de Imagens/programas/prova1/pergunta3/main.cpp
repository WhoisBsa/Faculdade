#include <opencv2/opencv.hpp>
#include <iostream>

using namespace cv;
using namespace std;


int main() {
    Mat imagem;

    Vec3b pixel, vermelho{0, 0, 255};

    imagem = imread("placa.jpg", IMREAD_COLOR);

    imshow("Foto", imagem);

    for (int i=0; i<imagem.rows; i++) {
        for(int j=0; j<imagem.cols; j++) {
            pixel = imagem.at<Vec3b>(i, j);
            if (pixel[0] <= 60 && pixel[1] <= 60 && pixel[2] <= 60 
            && pixel[0] >= 20 && pixel[1] >= 20 && pixel[2] >= 20) {
                imagem.at<Vec3b>(i,j) = vermelho;
             } 
        }
    }

    imshow("Foto Alterada", imagem);

    waitKey(0);
    return 0;
}