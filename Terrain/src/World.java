import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class World {


	public void build(Integer maxX, Integer maxY){

		Integer wood = 20;
		Integer rock = 0;
		Integer water = 20;
		Integer grass = 60;

		List<Case> listCase = new ArrayList<Case>();

		//400 = 20* 20
		Integer totalCase = maxX * maxY;

		Float totalWood = (totalCase / 100f) * wood;
		Integer iTotalWood = totalWood.intValue();

		Float totalRock = (totalCase / 100f) * rock;
		Integer iTotalRock = totalRock.intValue();

		Float totalWater = (totalCase / 100f) * water;
		Integer iTotalWater = totalWater.intValue();

		Float totalGrass = (totalCase / 100f) * grass;
		Integer iTotalGrass = totalGrass.intValue();

		Integer totalBiomeCase = 	iTotalWood + iTotalRock + iTotalWater +iTotalGrass;
		Integer diff = totalCase - totalBiomeCase;
		iTotalGrass +=  diff;
		totalBiomeCase = iTotalWood + iTotalRock + iTotalWater +iTotalGrass;

		System.out.println("total biomme = " +  totalBiomeCase);
		System.out.println("total case = " +  totalCase);

		System.out.println("total wook " + iTotalWood);
		System.out.println("total rock " + iTotalRock);
		System.out.println("total water " + iTotalWater);
		System.out.println("total grass " + iTotalGrass);


		
		while(listCase.size() != totalCase.intValue()){
			Case cCase = new Case();
			if( iTotalGrass > 0){			
				cCase.setTypeBiome("Grass");		
				iTotalGrass--;
				listCase.add(cCase);
			}
			else if( iTotalWater > 0){				
				cCase.setTypeBiome("Water");
				iTotalWater--;
				listCase.add(cCase);
			}
			else if( iTotalRock > 0){
				cCase.setTypeBiome("Rock");			
				iTotalRock--;
				listCase.add(cCase);
			}
			else if( iTotalWood > 0){						
				cCase.setTypeBiome("Wood");						
				iTotalWood--;
				listCase.add(cCase);
			}
		}
		
		
		long seed = System.nanoTime();
		Collections.shuffle(listCase, new Random(seed));
		

		int cptCase=0;
		for (int i = maxY - 1; i >= 0; i-- ) {
			
			for (int j = 0 ; j != maxX.intValue(); j++ ) {
				listCase.get(cptCase).setX(j);
				listCase.get(cptCase).setY(i);
				cptCase++;
			}
			
		}
		
		
		
		System.out.println("<html><body><table border='0' cellpadding='0' cellspacing='0'>");
		int currentY = maxY - 1;
		for (Case currentCase : listCase) {
		
			if(currentCase.getX() == 0 ){
				System.out.println("<tr>");
			}
			if(currentCase.getY() == currentY){
				if(currentCase.getTypeBiome().equals("Wood")){
					System.out.println("<td width='40px' height='40px'><img src='wood.png'/></td>");
				}
				if(currentCase.getTypeBiome().equals("Water")){
					System.out.println("<td  width='40px' height='40px'><img src='water.png'/></td>");
				}
				if(currentCase.getTypeBiome().equals("Grass")){
					System.out.println("<td width='40px' height='40px'><img src='grass.png'/></td>");
				}
				if(currentCase.getTypeBiome().equals("Rock")){
					System.out.println("<td  width='40px' height='40px'><img src='rock.png'/></td>");
				}
			}
			if(currentCase.getX() == maxX - 1 ){
				System.out.println("</tr>");
				currentY--;
			}
		}
		System.out.println("</table></body></html>");
		


	}

}
