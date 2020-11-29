#include <opencv2/opencv.hpp>
#include <iostream>

using namespace cv;
using namespace std;


int main() {
    Mat img1, img2, img3;
    Vec3b px;
    bool vermelho(false), verde(false), amarelo(false);

    img1 = imread("semaforo1.jpg", IMREAD_COLOR);
    img2 = imread("semaforo2.jpg", IMREAD_COLOR);
    img3 = imread("semaforo3.jpg", IMREAD_COLOR);

    // aqui você pode trocar qualquer uma das posições das imagens que 
    // continuará identificando corretamente, independente da ordem.
    Mat image[3] = {img1, img2, img3};

    for (int n = 0; n < 3; n++) {
        for (int i = 0; i < image[n].rows; i++) {
            for (int j = 0; j < image[n].cols; j++) {
                px = image[n].at<Vec3b>(i,j);
                
                if (px[0] <= 10 && px[1] <= 10 && px[2] >= 200) {
                    vermelho = true;
                    break;
                } else if (px[0] <= 30 && px[1] >= 200 && px[2] >= 200) {
                    amarelo = true;
                    break;
                } else if (px[0] <= 10 && px[1] >= 200 && px[2] <= 10) {
                    verde = true;
                    break;
                }
            }
        }
        if (vermelho) {
            cout << "Imagem " << n+1 << ": " << "Cor vermelha\n"; 
            vermelho = false;
        }
        else if (amarelo) {
            cout << "Imagem " << n+1 << ": " << "Cor Amarela\n";  
            amarelo = false;
        }
        else if (verde) {
            cout << "Imagem " << n+1 << ": " << "Cor Verde\n";
            verde = false;
        }
    }

    waitKey(0);

    return 0;
}