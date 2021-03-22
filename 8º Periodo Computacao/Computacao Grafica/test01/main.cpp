#define GLUT_DISABLE_ATEXIT_HACK

/*
======== Teste OpenGL ==================
Nairon Neri Silva
Vers�o 1.0
Programa teste da configura��o do GLUT
Desenha um quadrado vermelho na tela
========================================
*/

// #include <windows.h>
#include <GL/glut.h>
#include <stdlib.h>

//Fun��o callback para desenho
void desenha(void)
{
	//Inicializa o sistema de coordenadas
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();

	//Define os limites dos eixos x e y
	//Argumentos da fun��o: void gluOrtho2D(GLdouble left, GLdouble right, GLdouble bottom, GLdouble top)
	gluOrtho2D(0.0f, 500.0f, 0.0f, 500.0f);

	//Limpa todos os pixels com a cor de fundo
	glClear(GL_COLOR_BUFFER_BIT);

	//Configura a cor como vermelho
	glColor3f(1.0, 0.0, 0.0);

	// Desenha um quadrado preenchido com a cor corrente
	glBegin(GL_QUADS);
	glVertex2i(120, 400);
	glVertex2i(120, 120);
	glVertex2i(400, 120);
	glVertex2i(400, 400);
	glEnd();

	//Habilita a execu��o de comandos OpenGL
	glFlush();
}

//Inicializa par�metros
void init(void)
{
	// Configura a cor de fundo como preta
	glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
}

//Principal
int main(int argc, char **argv)
{
	glutInit(&argc, argv);
	//Tipo de janela (single-buffered) e cores utilizados
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);

	//Configura o tamanho da janela
	glutInitWindowSize(500, 500);

	//Configura a posi��o inicial da janela
	glutInitWindowPosition(100, 100);

	//Configura a janela
	glutCreateWindow("Teste do OpenGL");

	//Chama a fun��o desenha
	glutDisplayFunc(desenha);

	//Inicializa o programa
	init();

	//Habilita o loop (m�quina de estados)
	glutMainLoop();
}
