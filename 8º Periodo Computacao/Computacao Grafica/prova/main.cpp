// Matheus Barbosa Souza

#define GLUT_DISABLE_ATEXIT_HACK

#include <GL/glut.h>
#include <stdlib.h>
#include <stdio.h>

void drawCar();
void drawMargin();
void drawGround();

void draw(void){
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glMatrixMode(GL_MODELVIEW);
    glOrtho(0.0f, 50.0f, 0.0f, 50.0f, 0.0f, 50.0f);
    glClear(GL_COLOR_BUFFER_BIT);

    glPushMatrix();
        drawGround();
    glPopMatrix();
    
    glPushMatrix();
        glTranslatef(30, 0, 0);
        drawGround();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.0, 1.0, 1.0);
        glTranslatef(10, 10, 0);
        glScaled( 1.0, 0.2, 1);
        drawMargin();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.0, 1.0, 1.0);
        glTranslatef(10, 20, 0);
        glScaled( 1.0, 0.2, 1);
        drawMargin();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.0, 1.0, 1.0);
        glTranslatef(10, 30, 0);
        glScaled( 1.0, 0.2, 1);
        drawMargin();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.0, 1.0, 1.0);
        glTranslatef(10, 40, 0);
        glScaled( 1.0, 0.2, 1);
        drawMargin();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.0, 1.0, 1.0);
        glTranslatef(40, 10, 0);
        glScaled( 1.0, 0.2, 1);
        drawMargin();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.0, 1.0, 1.0);
        glTranslatef(40, 10, 0);
        glScaled( 1.0, 0.2, 1);
        drawMargin();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.0, 1.0, 1.0);
        glTranslatef(40, 20, 0);
        glScaled( 1.0, 0.2, 1);
        drawMargin();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.0, 1.0, 1.0);
        glTranslatef(40, 30, 0);
        glScaled( 1.0, 0.2, 1);
        drawMargin();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.0, 1.0, 1.0);
        glTranslatef(40, 40, 0);
        glScaled( 1.0, 0.2, 1);
        drawMargin();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.3, 1.0, 0.23);
        glTranslatef(40, 45, 0);
        glScaled( 0.5, 0.2, 1);
        drawCar();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.6, 1.0, 0.0);
        glTranslatef(40, 35, 0);
        glScaled( 0.4, 0.3, 1);
        drawCar();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.9, 0.0, 1.0);
        glTranslatef(40, 25, 0);
        glScaled( 0.4, 0.2, 1);
        drawCar();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.3, 0.12, 1.0);
        glTranslatef(40, 15, 0);
        glScaled( 0.4, 0.2, 1);
        drawCar();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.2, 1.0, 0.6);
        glTranslatef(40, 5, 0);
        glScaled( 0.4, 0.2, 1);
        drawCar();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.4, 0.7, 0.6);
        glTranslatef(10, 5, 0);
        glScaled( 0.6, 0.2, 1);
        drawCar();
    glPopMatrix();
    
    glPushMatrix();
        glColor3f (0.1, 0.2, 1.0);
        glTranslatef(10, 15, 0);
        glScaled( 0.8, 0.24, 1);
        drawCar();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.9, 0.7, 0.0);
        glTranslatef(10, 25, 0);
        glScaled( 0.43, 0.1, 1);
        drawCar();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.2, 0.5, 1.0);
        glTranslatef(10, 35, 0);
        glScaled( 0.6, 0.1, 1);
        drawCar();
    glPopMatrix();

    glPushMatrix();
        glColor3f (0.8, 1.0, 1.0);
        glTranslatef(11, 45, 0);
        glScaled( 0.4, 0.2, 1);
        drawCar();
    glPopMatrix();

    glFlush();
}

void drawCar() {
    glutSolidCube(20);
}

void drawMargin() {
    glutSolidCube(20);
}

void drawGround() {
    glBegin(GL_QUADS);
        glColor3f (10.0, 10.0, 10.0);
	    glVertex2i(0, 50);
	    glVertex2i(0, 0);
	    glVertex2i(20, 0);
	    glVertex2f(20, 50);
    glEnd();
}



void init(void){
    glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
}

int main(int argc, char *argv[]){

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
	glutDisplayFunc(draw);

	//Inicializa o programa
	init();

	//Habilita o loop (m�quina de estados)
	glutMainLoop();

}
