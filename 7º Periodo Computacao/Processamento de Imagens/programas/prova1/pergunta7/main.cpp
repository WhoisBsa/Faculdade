#include <opencv2/opencv.hpp>
#include <iostream>

using namespace cv;
using namespace std;


int main() {
    Mat img;

    img = imread("plane.jpg", IMREAD_GRAYSCALE);
    imshow("Foto", img);

    for (int i = 0; i < img.rows; i++) {
        for (int j = 0; j < img.cols/2; j++) {
            int valor = img.at<uchar>(i,j);
            if (valor < 255)
                img.at<uchar>(i,j) = 255 - valor;
            else if (valor == 0)
                img.at<uchar>(i,j) = 255;
            else if (valor == 0)
                img.at<uchar>(i,j) = 0;
        }
    }

    imshow("Foto em negativo", img);

    waitKey(0);
    return 0;
}