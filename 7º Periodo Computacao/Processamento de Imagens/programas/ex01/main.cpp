#include <opencv2/opencv.hpp>
#include <iostream>

using namespace std;
using namespace cv;


void reconhecer_faces(Mat imagem) {
  // 1º pessoa ✔
  rectangle(imagem, Point(245, 270), Point(195, 220), Scalar(0,255,0), 3, 8);
  // 2º pessoa ✔
  rectangle(imagem, Point(280, 150), Point(330, 100), Scalar(0,255,0), 3, 8);
  // 3º pessoa ✔
  rectangle(imagem, Point(400, 130), Point(450, 80), Scalar(0,255,0), 3, 8);
  // 4º pessoa ✔
  rectangle(imagem, Point(500, 150), Point(550, 100), Scalar(0,255,0), 3, 8);
  // 5º pessoa ✔
  rectangle(imagem, Point(600, 150), Point(650, 100), Scalar(0,255,0), 3, 8);
  // 6º pessoa ✔
  rectangle(imagem, Point(700, 180), Point(750, 130), Scalar(0,255,0), 3, 8);
  // 7º pessoa ✔
  rectangle(imagem, Point(795, 160), Point(845, 210), Scalar(0,255,0), 3, 8);
  // 8º pessoa ✔
  rectangle(imagem, Point(905, 130), Point(955, 180), Scalar(0,255,0), 3, 8);
}


void tampar_olhos(Mat imagem) {
  // 1º pessoa ✔
  line(imagem, Point(240, 250), Point(200,250), Scalar(0, 0, 0), 6, 8);
  // 2º pessoa ✔
  line(imagem, Point(285, 120), Point(310,120), Scalar(0, 0, 0), 6, 8);
  // 3º pessoa ✔
  line(imagem, Point(405, 100), Point(445,100), Scalar(0, 0, 0), 6, 8);
  // 4º pessoa ✔
  line(imagem, Point(505, 120), Point(545,120), Scalar(0, 0, 0), 6, 8);
  // 5º pessoa ✔
  line(imagem, Point(610, 118), Point(640,118), Scalar(0, 0, 0), 6, 8);
  // 6º pessoa ✔
  line(imagem, Point(710, 160), Point(745,160), Scalar(0, 0, 0), 6, 8);
  // 7º pessoa ✔
  line(imagem, Point(800, 190), Point(840,190), Scalar(0, 0, 0), 6, 8);
}


void salvar_fotos(Mat imagem) {
  imwrite("presosmarcados.png", imagem);
  Mat imagem_gray = imread("presosmarcados.png", IMREAD_GRAYSCALE);
  imwrite("presoswasted.png", imagem_gray);
}


int main() {
  Mat imagem;

  imagem = imread("presos.png", IMREAD_COLOR);

  if (!imagem.data) {
    cout << "Houve algum erro, tente novamente!";
    return 1;
  } else { 
    reconhecer_faces(imagem);
    tampar_olhos(imagem);
    salvar_fotos(imagem);
    imshow("Presos", imagem);
    waitKey(0);
  }

  return 0;
}