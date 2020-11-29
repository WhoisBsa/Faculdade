/*Algoritmo de http://www.calumk.com/old_posts_archive/0008//detecting-simple-shapes-in-an-image/*/

#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <cmath>
#include <iostream>

using namespace std;
using namespace cv;

/**
 * Função auxiliar para encontrar um cosseno de ângulo entre vetores
 * Do pt0->pt1 e pt0->pt2
 */
static double angle(Point pt1, Point pt2, Point pt0)
{
	double dx1 = pt1.x - pt0.x;
	double dy1 = pt1.y - pt0.y;
	double dx2 = pt2.x - pt0.x;
	double dy2 = pt2.y - pt0.y;
	return (dx1 * dx2 + dy1 * dy2) / sqrt((dx1 * dx1 + dy1 * dy1) * (dx2 * dx2 + dy2 * dy2) + 1e-10);
}

/**
 * Função auxiliar para exibir texto no centro de um contorno
 */
void setLabel(Mat& im, const string label, vector<Point>& contour)
{
	int fontface = FONT_HERSHEY_SIMPLEX;
	double scale = 0.4;
	int thickness = 1;
	int baseline = 0;

	Size text = getTextSize(label, fontface, scale, thickness, &baseline);
	Rect r = boundingRect(contour);

	Point pt(r.x + ((r.width - text.width) / 2), r.y + ((r.height + text.height) / 2));
	rectangle(im, pt + Point(0, baseline), pt + Point(text.width, -text.height), CV_RGB(255, 255, 255), FILLED);
	putText(im, label, pt, fontface, scale, CV_RGB(0, 0, 0), thickness, 8);
}

int main()
{	
	Mat image = imread("shapes.png");
	if (image.empty())
		return -1;

	//Converte para grayscale
	Mat gray;
	cvtColor(image, gray, COLOR_BGR2GRAY);

	//Utiliza o algoritmo Canny capturar quadrados com sombreamento gradiente
	Mat bw;
	Canny(gray, bw, 0, 50, 5);

	//Procura os contornos
	vector<vector<Point>> contours;
	findContours(bw.clone(), contours, RETR_EXTERNAL, CHAIN_APPROX_SIMPLE);

	vector<Point> approx;
	Mat image_classified = image.clone();

	for (int i = 0; i < contours.size(); i++)
	{
		//Aplica a função de contorno aproximado
		approxPolyDP(Mat(contours[i]), approx, arcLength(Mat(contours[i]), true) * 0.02, true);

		//desconsidera objetos pequenos ou não convexos
		if (fabs(contourArea(contours[i])) < 100 || !isContourConvex(approx))
			continue;

		//verifica se é um triangulo
		if (approx.size() == 3)
		{
			setLabel(image_classified, "TRI", contours[i]);
		}
		else if (approx.size() >= 4 && approx.size() <= 6)//verifica se é um polígono
		{
			//Número de vértices da curva poligonal
			int vtc = approx.size();

			//Obtem o cosseno de todos os cantos
			vector<double> cos;
			for (int j = 2; j < vtc + 1; j++)
				cos.push_back(angle(approx[j % vtc], approx[j - 2], approx[j - 1]));

			//Ordena os valores do cosseno em ordem crescente
			sort(cos.begin(), cos.end());

			//Obtem o cosseno mais baixo e o mais alto
			double mincos = cos.front();
			double maxcos = cos.back();

			// Usa o valor dos graus obtidos e o número de vértices
			//para definir qual o tipo da forma
			if (vtc == 4 && mincos >= -0.1 && maxcos <= 0.3)//retângulo
				setLabel(image_classified, "RECT", contours[i]);
			else if (vtc == 5 && mincos >= -0.34 && maxcos <= -0.27)//pentágono
				setLabel(image_classified, "PENTA", contours[i]);
			else if (vtc == 6 && mincos >= -0.55 && maxcos <= -0.45)//hexágono
				setLabel(image_classified, "HEXA", contours[i]);
		}
		else
		{
			//Verifica se é um círculo
			double area = contourArea(contours[i]);
			Rect r = boundingRect(contours[i]);
			int radius = r.width / 2;

			if (abs(1 - ((double)r.width / r.height)) <= 0.2 &&
				abs(1 - (area / (CV_PI * pow(radius, 2)))) <= 0.2)
				setLabel(image_classified, "CIR", contours[i]);
		}
	}

	imshow("Imagem Original", image);
	imshow("Imagem Classificada", image_classified);
	waitKey(0);
	return 0;
}