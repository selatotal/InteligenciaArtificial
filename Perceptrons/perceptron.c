//-------------------------------------------------------------------------
// Exemplo de uma Rede Neural PERCEPTRON
// Prof. Tales Viegas                                           
// ------------------------------------------------------------------------

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

// -------------------------- Variaveis -----------------------------------
// Tabela OR
//                      x1  x2
int entrada[4][2] = { { -1, -1 },
                      { -1,  1 },
                      {  1, -1 },
                      {  1,  1 } };
//Saidas desejadas
int d[4] = {-1, 1, 1, 1 };

//Pesos do neuronio
// Posicao 0 : bias
// Posicoes 1 e 2 : x1 e x2, respectivamente
double pesos[3] = { 0, 0, 0 };

//Taxa de Aprendizagem
double taxa = 1;

//-------------------------- Prototipos------------------------------------
int sinal(double v);
void treinamento();
void generalizacao();
void esc_pesos();

int main()
{
      printf("Iniciando treinamento...\n");
      treinamento();
      
      printf("Treinamento encerrado. Iniciando generalizacao\n");
      generalizacao();
      
      printf("Processo concluido\n");
      return 0;
}

//-------------------------- Funcoes ---------------------------------------

int sinal(double v){

   if(v>= 0) return 1;

   return -1;
}

void treinamento(){
    int i, j, epocas = 0;
    double soma, y, erro=0, erroTotal=0;

    printf("\n--------- ETAPA DE TREINAMENTO ------------\n");
    printf("\nPesos Iniciais : ");
    esc_pesos();

    do{
          epocas++;
	  	  erroTotal=0;
          printf("\nEpoca : %d", epocas);
          printf("\n===========\n");

          for(i=0; i<4; i++){
             soma = pesos[0];
             for(j=0; j<2; j++){
                 printf("\nx%d   = %d ",j+1, entrada[i][j]);
                 soma += entrada[i][j] * pesos[j+1];
             }
             printf("\n");

             y = sinal(soma);
             erro = d[i] - y;
             printf("\nErro = %lf ", erro);

             pesos[0] += taxa * erro;
             pesos[1] += taxa * erro * entrada[i][0];
             pesos[2] += taxa * erro * entrada[i][1];
             esc_pesos();
	     	 erroTotal = erroTotal + fabs(erro);
          }
    }while(erroTotal);

    printf("\nA rede foi treinada em %d epocas\n\n",epocas);
}

void generalizacao(){
  int resp=1;
  double soma, y, x1,x2;

  printf("\n--------- ETAPA DE GENERALIZACAO ------------\n");
  while(resp==1){

     printf("\n\nDigite os valores de entrada da rede: \n");
     printf("x1 = ");
     scanf("%lf", &x1);
     printf("x2 = ");
     scanf("%lf", &x2);

     soma  = pesos[0];
     soma += pesos[1] * x1;
     soma += pesos[2] * x2;
     y = sinal(soma);

     printf("\n\nSaida da rede = %lf\n", y);
     printf("\nContinua (1-Sim/2-Nao) ? ");
     scanf("%d",&resp);
  }

}

void esc_pesos(){

  printf("\nW10  = %lf (Bias)", pesos[0]);
  printf("\nW11  = %lf", pesos[1]);
  printf("\nW12  = %lf\n\n", pesos[2]);

}

