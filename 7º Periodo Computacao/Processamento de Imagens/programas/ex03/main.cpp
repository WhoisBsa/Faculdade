#include <opencv2/opencv.hpp>
#include <iostream>
#include <ctime>


using namespace cv;
using namespace std;


int main() {
    Mat img;
    Vec3b branco{255, 255, 255};
    Point p;

    srand(time(NULL)); // Evitar o pseudorandom

    int qtd_points = rand() % 1000 + 1;
    int n_obj = 0;

    img = imread("imagem.png", IMREAD_GRAYSCALE);

    int height = img.rows;
    int width = img.cols;
    p.x = 0;
    p.y = 0;

    for (int i = 0; i < qtd_points; i++) {
        img.at<Vec3b>(rand() % height, rand() % width) = branco;
    }

    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            if (img.at<uchar>(i, j) == 255) {
                n_obj++;
                p.x = j;
                p.y = i;
                floodFill(img, p, 150);
            }
        }
    }

    cout << "Quantidade de pontos: " << qtd_points << "\n";
    cout << "Objetos encontrados: " << n_obj << "\n";
    

    namedWindow("Pontos", WINDOW_NORMAL);
    resizeWindow("Pontos", 854, 480);
    imshow("Pontos", img);

    waitKey(0);

    return 0;
}