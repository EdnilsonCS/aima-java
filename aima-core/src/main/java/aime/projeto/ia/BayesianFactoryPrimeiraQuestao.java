package aime.projeto.ia;

import aima.core.probability.bayes.BayesianNetwork;
import aima.core.probability.bayes.FiniteNode;
import aima.core.probability.bayes.impl.BayesNet;
import aima.core.probability.bayes.impl.FullCPTNode;
import aima.core.probability.example.ExercicioFinalRV;

public class BayesianFactoryPrimeiraQuestao {

	public static BayesianNetwork constructAmericanYoungerCatchLikesSoccerWatchsSportTVNetwork() {
		
		FiniteNode age = new FullCPTNode(ExercicioFinalRV.AGE_RV, new double[] {
				0.3, 
				0.6,
				0.1 
			});

		FiniteNode american = new FullCPTNode(ExercicioFinalRV.AMERICAN_RV, new double[] {
				0.2, 
				0.8 
			});
			
		@SuppressWarnings("unused")
		FiniteNode likeSports = new FullCPTNode(ExercicioFinalRV.LIKES_SOCCER_RV,
				new double[] {
						0.5,
						0.5,
						0.7,
						0.3,
						0.6,
						0.4,
						0.8,
						0.2,
						0.4,
						0.6,
						0.1,
						0.9
				}, age, american);

		@SuppressWarnings("unused")
		FiniteNode watch = new FullCPTNode(ExercicioFinalRV.WATCH_SOME_RV, new double[] {
				0.7,
				0.2,
				0.1,
				0.5,
				0.3,
				0.2
			}, likeSports);

		return new BayesNet(age, american);
	}

}
