package aima.gui.demo.probability;

import aima.core.probability.FiniteProbabilityModel;
import aima.core.probability.bayes.approx.BayesInferenceApproxAdapter;
import aima.core.probability.bayes.approx.GibbsAsk;
import aima.core.probability.bayes.model.FiniteBayesModel;
import aima.core.probability.example.BayesNetExampleFactory;
import aima.core.probability.example.ExampleRV;
import aima.core.probability.proposition.AssignmentProposition;
import aima.core.probability.bayes.approx.LikelihoodWeighting;

public class ExerciseFinal {
  public static final int NUM_SAMPLES = 10000000; 

  public static void main(String[] args) {

    System.out.println("-------------------QUESTÃO 1 LETRA A-----------------");
    //Questão A
		bayesGibbsWorldQuestionA();
		bayesLikelihoodWeightingWorldQuestionA();
    System.out.println("");
		System.out.println("-------------------QUESTÃO 1 LETRA B-----------------");
		//Questão B
		bayesGibbsWorldQuestionB();
    bayesLikelihoodWeightingQuestionB();
		System.out.println("");
		System.out.println("-------------------QUESTÃO 1 LETRA C-----------------");
		//Questão C
		bayesGibbsWorldQuestionC();
		bayesLikelihoodWeightingQuestionC();
  }



  public static void bayesLikelihoodWeightingWorldQuestionA(){

		System.out.println("DEMO: probability we find a non-American who is younger than likes soccer and watches TV N = " + NUM_SAMPLES);
		System.out.println("=====================LIKELIHOOD===================");
    demoSoccerProbabilityNONAmericanYoungerLikesSoccerWatchsSportTV(
			new FiniteBayesModel(
				BayesNetExampleFactory.constructAmericanYoungerCatchLikesSoccerWatchsSportTVNetwork(),
				new BayesInferenceApproxAdapter(new LikelihoodWeighting(), NUM_SAMPLES))
		);
	}


	public static void bayesGibbsWorldQuestionA(){

		System.out.println("DEMO: probability we find a non-American who is younger than likes soccer and watches TV N = " + NUM_SAMPLES);
		System.out.println("=====================GIBBS===================");
    demoSoccerProbabilityNONAmericanYoungerLikesSoccerWatchsSportTV(
			new FiniteBayesModel(
				BayesNetExampleFactory.constructAmericanYoungerCatchLikesSoccerWatchsSportTVNetwork(),
				new BayesInferenceApproxAdapter(new GibbsAsk(), NUM_SAMPLES))
		);
	}

	public static void bayesGibbsWorldQuestionB(){
		System.out.println("DEMO: probability we find a between = " + NUM_SAMPLES);
		System.out.println("=====================GIBBS===================");
		System.out.println("P<>(watch tv = true | nonAmerican AND younger than 30)");
		demoSoccerProbabilityWatchTVNonAmericanYougerThan30(
			new FiniteBayesModel(
				BayesNetExampleFactory.constructAmericanYoungerCatchLikesSoccerWatchsSportTVNetwork(),
				new BayesInferenceApproxAdapter(new GibbsAsk(), NUM_SAMPLES))
		);
	}
 

  public static void bayesLikelihoodWeightingQuestionB(){
    System.out.println("DEMO: probability we find a between = " + NUM_SAMPLES);
		System.out.println("=====================LIKELIHOOD===================");
		System.out.println("P<>(watch tv = true | nonAmerican AND younger than 30)");
		demoSoccerProbabilityWatchTVNonAmericanYougerThan30(
			new FiniteBayesModel(
				BayesNetExampleFactory.constructAmericanYoungerCatchLikesSoccerWatchsSportTVNetwork(),
				new BayesInferenceApproxAdapter(new LikelihoodWeighting(), NUM_SAMPLES))
		);
  }


	public static void bayesGibbsWorldQuestionC(){
		System.out.println("DEMO: probability we find a between = " + NUM_SAMPLES);
		System.out.println("=====================GIBBS===================");
		System.out.println("P<>(likes and over40yar AND watchesSports)");
		constructOver40YearsOldWhoNeverWatchsSportsLikesFutebolNetwork(
			new FiniteBayesModel(
				BayesNetExampleFactory.constructAmericanYoungerCatchLikesSoccerWatchsSportTVNetwork(),
				new BayesInferenceApproxAdapter(new GibbsAsk(), NUM_SAMPLES))
		);
	}

  public static void bayesLikelihoodWeightingQuestionC(){
		System.out.println("DEMO: probability we find a between = " + NUM_SAMPLES);
		System.out.println("=====================LIKELIHOOD===================");
		System.out.println("P<>(likes | over40yar AND watchesSports)");
		constructOver40YearsOldWhoNeverWatchsSportsLikesFutebolNetwork(
			new FiniteBayesModel(
				BayesNetExampleFactory.constructAmericanYoungerCatchLikesSoccerWatchsSportTVNetwork(),
				new BayesInferenceApproxAdapter(new LikelihoodWeighting(), NUM_SAMPLES))
		);
	}

	public static void demoSoccerProbabilityNONAmericanYoungerLikesSoccerWatchsSportTV(FiniteProbabilityModel model){
		System.out.println(" non American, Younger than 30, Likes Soccer , Watch TV");
		System.out.println("----------------------------------");
		
		AssignmentProposition nonAmerican = new AssignmentProposition(
			ExampleRV.AMERICAN_RV, Boolean.FALSE);

		AssignmentProposition aYoungerThan30 = new AssignmentProposition(
				ExampleRV.AGE_RV, "a1");
		
		AssignmentProposition aLikeSoccer = new AssignmentProposition(
				ExampleRV.LIKES_SOCCER_RV, Boolean.TRUE);	
		
		AssignmentProposition aWatchALotTV = new AssignmentProposition(
					ExampleRV.WATCH_SOME_RV, "lot");

		System.out.println("P<>(nAmerican, Younger, aLikeSoccer, aWatchALotTV) = "
				+ model.prior(nonAmerican,
				aYoungerThan30,aLikeSoccer,aWatchALotTV));

	}

  public static void demoSoccerProbabilityWatchTVNonAmericanYougerThan30(FiniteProbabilityModel model){
    System.out.println("P<>(LIKES = true | American AND younger between 31-40 AND watch tv = some)");
    
    AssignmentProposition aLikeSoccer = new AssignmentProposition(
				ExampleRV.LIKES_SOCCER_RV, Boolean.TRUE);	

    AssignmentProposition american = new AssignmentProposition(
			ExampleRV.AMERICAN_RV, Boolean.TRUE);

    AssignmentProposition aWatchALotTV = new AssignmentProposition(
					ExampleRV.WATCH_SOME_RV, "some");
    
    AssignmentProposition aYoungerThan30 = new AssignmentProposition(
            ExampleRV.AGE_RV, "a2");      
    
    System.out.println("P<>(LIKES = true | American AND younger between 31-40 AND watch tv = some) = "
            + model.posterior(aLikeSoccer, american,
            aWatchALotTV,aYoungerThan30 ));        
	}

	public static void constructOver40YearsOldWhoNeverWatchsSportsLikesFutebolNetwork(FiniteProbabilityModel model){
		System.out.println("P<>(LIKES = true AND American AND old over 40 AND watch tv = none)");
	   
		AssignmentProposition aLikeSoccer = new AssignmentProposition(
				ExampleRV.LIKES_SOCCER_RV, Boolean.TRUE);	

				AssignmentProposition aYoungerOver40 = new AssignmentProposition(
					ExampleRV.AGE_RV, "a3");   

    AssignmentProposition noneWatchTV = new AssignmentProposition(
					ExampleRV.WATCH_SOME_RV, "none");

		System.out.println("P<>(LIKES = true AND American AND old over 40 AND watch tv = none) = "
					+ model.prior(aLikeSoccer, aYoungerOver40,
					noneWatchTV )); 
	}
}
