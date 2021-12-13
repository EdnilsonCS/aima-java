package aima.projeto.ia;

import aima.core.probability.FiniteProbabilityModel;
import aima.core.probability.bayes.approx.BayesInferenceApproxAdapter;
import aima.core.probability.bayes.approx.GibbsAsk;
import aima.core.probability.bayes.approx.LikelihoodWeighting;
import aima.core.probability.bayes.model.FiniteBayesModel;
import aima.core.probability.example.ExercicioFinalRV;
import aima.core.probability.proposition.AssignmentProposition;
import aime.projeto.ia.BayesianFactoryPrimeiraQuestao;

public class Questao1 {
  public static final int NUM_SAMPLES = 10000; 

  public static void main(String[] args) {

    System.out.println("-------------------QUESTÃO 1 LETRA A-----------------");
    //Questão A
    	long tempoInicial = System.currentTimeMillis();
		bayesGibbsWorldQuestionA();
		bayesLikelihoodWeightingWorldQuestionA();
		long tempoFinal = System.currentTimeMillis();
	    System.out.printf("Tempo de Execu��o ~> %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
    System.out.println("");
		System.out.println("-------------------QUESTÃO 1 LETRA B-----------------");
		//Questão B
		tempoInicial = System.currentTimeMillis();
		bayesGibbsWorldQuestionB();
		bayesLikelihoodWeightingQuestionB();
		tempoFinal = System.currentTimeMillis();
	    System.out.printf("Tempo de Execu��o ~> %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
	System.out.println("");
		System.out.println("-------------------QUESTÃO 1 LETRA C-----------------");
		//Questão C
		tempoInicial = System.currentTimeMillis();
		bayesGibbsWorldQuestionC();
		bayesLikelihoodWeightingQuestionC();
		tempoFinal = System.currentTimeMillis();
	    System.out.printf("Tempo de Execu��o ~> %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
  }



  public static void bayesLikelihoodWeightingWorldQuestionA(){

		System.out.println("DEMO: probability we find a non-American who is younger than likes soccer and watches TV N = " + NUM_SAMPLES);
		System.out.println("=====================LIKELIHOOD===================");
    demoSoccerProbabilityNONAmericanYoungerLikesSoccerWatchsSportTV(
			new FiniteBayesModel(
				BayesianFactoryPrimeiraQuestao.constructAmericanYoungerCatchLikesSoccerWatchsSportTVNetwork(),
				new BayesInferenceApproxAdapter(new LikelihoodWeighting(), NUM_SAMPLES))
		);
	}


	public static void bayesGibbsWorldQuestionA(){

		System.out.println("DEMO: probability we find a non-American who is younger than likes soccer and watches TV N = " + NUM_SAMPLES);
		System.out.println("=====================GIBBS===================");
    demoSoccerProbabilityNONAmericanYoungerLikesSoccerWatchsSportTV(
			new FiniteBayesModel(
				BayesianFactoryPrimeiraQuestao.constructAmericanYoungerCatchLikesSoccerWatchsSportTVNetwork(),
				new BayesInferenceApproxAdapter(new GibbsAsk(), NUM_SAMPLES))
		);
	}

	public static void bayesGibbsWorldQuestionB(){
		System.out.println("DEMO: probability we find a between = " + NUM_SAMPLES);
		System.out.println("=====================GIBBS===================");
		System.out.println("P(C = c1 | A = a2, B = b1, D = d2) ");
		demoSoccerProbabilityWatchTVNonAmericanYougerThan30(
			new FiniteBayesModel(
				BayesianFactoryPrimeiraQuestao.constructAmericanYoungerCatchLikesSoccerWatchsSportTVNetwork(),
				new BayesInferenceApproxAdapter(new GibbsAsk(), NUM_SAMPLES))
		);
	}
 

  public static void bayesLikelihoodWeightingQuestionB(){
    System.out.println("DEMO: probability we find a between = " + NUM_SAMPLES);
		System.out.println("=====================LIKELIHOOD===================");
		System.out.println("P(C = c1 | A = a2, B = b1, D = d2) ");
		demoSoccerProbabilityWatchTVNonAmericanYougerThan30(
			new FiniteBayesModel(
				BayesianFactoryPrimeiraQuestao.constructAmericanYoungerCatchLikesSoccerWatchsSportTVNetwork(),
				new BayesInferenceApproxAdapter(new LikelihoodWeighting(), NUM_SAMPLES))
		);
  }


	public static void bayesGibbsWorldQuestionC(){
		System.out.println("DEMO: probability we find a between = " + NUM_SAMPLES);
		System.out.println("=====================GIBBS===================");
		System.out.println("P(C = c1 | A = a3, D = d3)");
		constructOver40YearsOldWhoNeverWatchsSportsLikesFutebolNetwork(
			new FiniteBayesModel(
				BayesianFactoryPrimeiraQuestao.constructAmericanYoungerCatchLikesSoccerWatchsSportTVNetwork(),
				new BayesInferenceApproxAdapter(new GibbsAsk(), NUM_SAMPLES))
		);
	}

  public static void bayesLikelihoodWeightingQuestionC(){
		System.out.println("DEMO: probability we find a between = " + NUM_SAMPLES);
		System.out.println("=====================LIKELIHOOD===================");
		System.out.println("P<>(likes | over40yar AND watchesSports)");
		constructOver40YearsOldWhoNeverWatchsSportsLikesFutebolNetwork(
			new FiniteBayesModel(
				BayesianFactoryPrimeiraQuestao.constructAmericanYoungerCatchLikesSoccerWatchsSportTVNetwork(),
				new BayesInferenceApproxAdapter(new LikelihoodWeighting(), NUM_SAMPLES))
		);
	}

	public static void demoSoccerProbabilityNONAmericanYoungerLikesSoccerWatchsSportTV(FiniteProbabilityModel model){
		System.out.println("----------------------------------");
		
		AssignmentProposition nonAmerican = new AssignmentProposition(
			ExercicioFinalRV.AMERICAN_RV, Boolean.FALSE);

		AssignmentProposition aYoungerThan30 = new AssignmentProposition(
				ExercicioFinalRV.AGE_RV, "a1");
		
		AssignmentProposition aLikeSoccer = new AssignmentProposition(
				ExercicioFinalRV.LIKES_SOCCER_RV, Boolean.TRUE);	
		
		AssignmentProposition aWatchALotTV = new AssignmentProposition(
					ExercicioFinalRV.WATCH_SOME_RV, "lot");

		System.out.println("p(~A, A = a1, C , D = d3) = "
				+ model.prior(nonAmerican,
				aYoungerThan30,aLikeSoccer,aWatchALotTV));

	}

  public static void demoSoccerProbabilityWatchTVNonAmericanYougerThan30(FiniteProbabilityModel model){
    
    AssignmentProposition aLikeSoccer = new AssignmentProposition(
				ExercicioFinalRV.LIKES_SOCCER_RV, Boolean.TRUE);	

    AssignmentProposition american = new AssignmentProposition(
			ExercicioFinalRV.AMERICAN_RV, Boolean.TRUE);

    AssignmentProposition aWatchALotTV = new AssignmentProposition(
					ExercicioFinalRV.WATCH_SOME_RV, "some");
    
    AssignmentProposition aYoungerThan30 = new AssignmentProposition(
            ExercicioFinalRV.AGE_RV, "a2");      
    
    System.out.println("p(C = c1 | A = a2, B = b1, D = d2) = "
            + model.posterior(aLikeSoccer, american,
            aWatchALotTV,aYoungerThan30 ));        
	}

	public static void constructOver40YearsOldWhoNeverWatchsSportsLikesFutebolNetwork(FiniteProbabilityModel model) {
		AssignmentProposition aLikeSoccer = new AssignmentProposition(ExercicioFinalRV.LIKES_SOCCER_RV, Boolean.TRUE);

		AssignmentProposition aYoungerOver40 = new AssignmentProposition(ExercicioFinalRV.AGE_RV, "a3");

		AssignmentProposition noneWatchTV = new AssignmentProposition(ExercicioFinalRV.WATCH_SOME_RV, "none");

		System.out.println("P(C = c1 | A = a3, D = d3 )= " + model.posterior(aLikeSoccer, aYoungerOver40, noneWatchTV));
	}
}
