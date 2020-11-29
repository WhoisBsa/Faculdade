#include <opencv2/opencv.hpp>
#include <iostream>

using namespace cv;
using namespace std;


void blur_presos(Mat imagem) {
    Point tl, tb;
    Rect region;

    tl = Point(245, 270);
    tb = Point(195, 220);
    region = Rect(tl, tb);
    GaussianBlur(imagem(region), imagem(region), Size(15,15), 4);

    tl = Point(280, 150);
    tb = Point(330, 100);
    region = Rect(tl, tb);
    GaussianBlur(imagem(region), imagem(region), Size(15,15), 4);

    tl = Point(400, 130);
    tb = Point(450, 80);
    region = Rect(tl, tb);
    GaussianBlur(imagem(region), imagem(region), Size(15,15), 4);
    
    tl = Point(500, 150);
    tb = Point(550, 100);
    region = Rect(tl, tb);
    GaussianBlur(imagem(region), imagem(region), Size(15,15), 4);

    tl = Point(600, 150);
    tb = Point(650, 100);
    region = Rect(tl, tb);
    GaussianBlur(imagem(region), imagem(region), Size(15,15), 4);

    tl = Point(700, 180);
    tb = Point(750, 130);
    region = Rect(tl, tb);
    GaussianBlur(imagem(region), imagem(region), Size(15,15), 4);

    tl = Point(795, 160);
    tb = Point(845, 210);
    region = Rect(tl, tb);
    GaussianBlur(imagem(region), imagem(region), Size(15,15), 4);

    tl = Point(905, 130);
    tb = Point(955, 180);
    region = Rect(tl, tb);
    GaussianBlur(imagem(region), imagem(region), Size(15,15), 4);   
}

int main() {
    Mat imagem;

    imagem = imread("presos.png", IMREAD_COLOR);

    blur_presos(imagem);

    imshow("Presos", imagem);

    waitKey(0);

    return 0;
}