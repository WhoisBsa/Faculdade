#include <iostream>
#include "opencv2/opencv.hpp"

using namespace std;
using namespace cv; 

int main(int argc, char** argv) {
    Mat image, border;    

    //abre a imagem
    image = imread("asfaltada.jpeg", IMREAD_GRAYSCALE);

    GaussianBlur(image, image, Size(15,15), 4);
    //aplica o filtro de Canny
    Canny(image, border, 10, 40);
    //exibe a imagem
    imshow("Canny", border);
    namedWindow("Canny", 1);            

    waitKey();

    return 0;
}