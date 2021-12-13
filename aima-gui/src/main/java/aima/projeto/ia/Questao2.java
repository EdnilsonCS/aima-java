
package aima.projeto.ia;

import aima.core.probability.FiniteProbabilityModel;
import aima.core.probability.bayes.approx.BayesInferenceApproxAdapter;
import aima.core.probability.bayes.approx.GibbsAsk;
import aima.core.probability.bayes.approx.LikelihoodWeighting;
import aima.core.probability.bayes.model.FiniteBayesModel;
import aima.core.probability.example.ExercicioFinalRV;
import aima.core.probability.proposition.AssignmentProposition;
import aime.projeto.ia.BayesianFactorySegundaQuestao;

public class Questao2 {
  public static final int NUM_SAMPLES = 100000; 


  public static void main(String[] args) {
    System.out.println("-------------------QUESTÃO 2 -----------------");
    long tempoInicial = System.currentTimeMillis();
    bayesGibbsRendaFamiliarIgualA3SalariosMinimos();
    long tempoFinal = System.currentTimeMillis();
	System.out.printf("Tempo de Execucao bayesGibbsRendaFamiliarIgualA3SalariosMinimos ~> %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
	tempoInicial = System.currentTimeMillis();
    bayesGibbsGanharBolsaSendoEstudanteDoEnsinoMedioEscolaPublica();
    tempoFinal = System.currentTimeMillis();
    System.out.printf("Tempo de Execucao bayesGibbsGanharBolsaSendoEstudanteDoEnsinoMedioEscolaPublica ~> %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
    tempoInicial = System.currentTimeMillis();
    bayesLikelihoodWeightingRendaFamiliarIgualA3SalariosMinimos();
    tempoFinal = System.currentTimeMillis();
    System.out.printf("Tempo de Execucao  bayesLikelihoodWeightingRendaFamiliarIgualA3SalariosMinimos ~> %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
    tempoInicial = System.currentTimeMillis();
    bayesLikelihoodWeightingGanharBolsaSendoEstudanteDoEnsinoMedioEscolaPublica();
    tempoFinal = System.currentTimeMillis();
    System.out.printf("Tempo de Execucao  bayesLikelihoodWeightingGanharBolsaSendoEstudanteDoEnsinoMedioEscolaPublica ~> %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
  }

  public static void bayesLikelihoodWeightingRendaFamiliarIgualA3SalariosMinimos(){
    System.out.println("DEMO: Probabilidade da Renda Familiar ser de um a três salários mínimos: N = " + NUM_SAMPLES);
		System.out.println("=====================LIKELIHOOD===================");
    demoBayesGibbsRendaFamiliarIgualA3SalariosMinimos(
			new FiniteBayesModel(
				BayesianFactorySegundaQuestao.constructBolsaNetwork(),
				new BayesInferenceApproxAdapter(new LikelihoodWeighting(), NUM_SAMPLES))
		);
  }

  public static void bayesGibbsRendaFamiliarIgualA3SalariosMinimos(){

		System.out.println("DEMO: Probabilidade da Renda Familiar ser de um a três salários mínimos: N = " + NUM_SAMPLES);
		System.out.println("=====================GIBBS===================");
    demoBayesGibbsRendaFamiliarIgualA3SalariosMinimos(
			new FiniteBayesModel(
				BayesianFactorySegundaQuestao.constructBolsaNetwork(),
				new BayesInferenceApproxAdapter(new GibbsAsk(), NUM_SAMPLES))
		);
  }


  public static void  bayesLikelihoodWeightingGanharBolsaSendoEstudanteDoEnsinoMedioEscolaPublica(){
    System.out.println("DEMO: Probabilidade de ganhar bolsa sendo que fez ensino médio em escola pública: N = " + NUM_SAMPLES);
    System.out.println("=====================LIKELIHOOD===================");
    demoBayesGibbsEstudouEscolaPublica(
			new FiniteBayesModel(
				BayesianFactorySegundaQuestao.constructBolsaNetwork(),
				new BayesInferenceApproxAdapter(new LikelihoodWeighting(), NUM_SAMPLES))
		);
  }

  public static void bayesGibbsGanharBolsaSendoEstudanteDoEnsinoMedioEscolaPublica(){
    System.out.println("DEMO: Probabilidade de ganhar bolsa sendo que fez ensino médio em escola pública: N = " + NUM_SAMPLES);
		System.out.println("=====================GIBBS===================");
    demoBayesGibbsEstudouEscolaPublica(
			new FiniteBayesModel(
				BayesianFactorySegundaQuestao.constructBolsaNetwork(),
				new BayesInferenceApproxAdapter(new GibbsAsk(), NUM_SAMPLES))
		);
  }

  public static void demoBayesGibbsEstudouEscolaPublica(FiniteProbabilityModel model){
    AssignmentProposition estudou_publica = new AssignmentProposition(
      ExercicioFinalRV.SEGUNDO_GRAU_RV, "publico");
    
    AssignmentProposition estudou_privada = new AssignmentProposition(
        ExercicioFinalRV.SEGUNDO_GRAU_RV, "privado");


    Double  probabilidadeEstudouEmEscolaPublica =  model.prior( ExercicioFinalRV.BOLSA_RV, estudou_publica);
    Double  probabilidadeEstudouEmEscolaParticula =  model.prior( ExercicioFinalRV.BOLSA_RV, estudou_privada);
   
     System.out.println("probabilidade de ter estudado em escola publica = " + probabilidadeEstudouEmEscolaPublica);
     System.out.println("probabilidade de estudado em escola privada = " + probabilidadeEstudouEmEscolaParticula);
  }

    public static void demoBayesGibbsRendaFamiliarIgualA3SalariosMinimos(FiniteProbabilityModel model){
      AssignmentProposition renda_1_3 = new AssignmentProposition(
        ExercicioFinalRV.RENDA_FAMILIAR_RV, "1_a_3_sm");
      
      AssignmentProposition renda_4_10 = new AssignmentProposition(
          ExercicioFinalRV.RENDA_FAMILIAR_RV, "4_a_10_sm");

      AssignmentProposition renda_mais_10 = new AssignmentProposition(
            ExercicioFinalRV.RENDA_FAMILIAR_RV, "10_sm");

          
      Double  probabilidade10eAte3SalarioMinimo =  model.prior( ExercicioFinalRV.BOLSA_RV, renda_1_3);
      Double  probabilidadeate10SalarioMinimo =  model.prior( ExercicioFinalRV.BOLSA_RV, renda_4_10);
      Double  probabilidademais10SalarioMinimo =  model.prior( ExercicioFinalRV.BOLSA_RV, renda_mais_10);
   
     System.out.println("probabilidade de 1 a 3 salarios minimos = " + probabilidade10eAte3SalarioMinimo);
     System.out.println("probabilidade de 4 a 10 salarios minimos = " + probabilidadeate10SalarioMinimo);
     System.out.println("probabilidade mais de 10 salarios minimos = " + probabilidademais10SalarioMinimo);
     
	};
}

