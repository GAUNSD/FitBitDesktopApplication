package ca.uwo.csd.cs2212.team10;
/**
 * This class will be used to determine if the user has achieved accolades 
 * @author Neeraja Murali Dharan 
 */

public class Accolades {
	Accolade_Node[]accolades=new Accolade_Node[20];
	public Accolades(){
		for (int i=0; i<accolades_check.length;i++){
			accolades[i]=new Accolade_Node(); 
		}
	}
	public boolean[] getAccolades(int unit){
		return accolades_check;
	}
	public void set_accolades(BestLifeStats bestlife,DailyStats daily,HeartStats heartrate){
		accolades[0].setTitle("Fitness God");
		accolades[0].setDescription("Congratulations! Your peak heart rate is faster than Eminem's Rap God (148BPM). Thats quite an achievement");
		if (heartrate.getPeak()>148){
			accolades[0].setCheck(true);
		}
		accolades[1].setTitle("You Beat It");
		accolades[1].setDescription("Your cardio heart rate just surpassed Michael Jackson’s Beat It(148 BPM).So beat it, just beat it!");
		if (heartrate.getCardio()>148){
			accolades[1].setCheck(true);
		}
		accolades[2].setTitle("Live La Vida Loca");
		accolades[2].setDescription("Even Ricky Martin guessed it! Your peak heart rate is higher than 178 BPM, faster than Livin’ La Vida Loca. Come on!");
		if (heartrate.getPeak()>178){
			accolades[2].setCheck(true);
		}
		accolades[3].setTitle("Half A Marathon");
		accolades[3].setDescription("You just ran 21 kilometers, or half a marathon. You’re so fit, you make hearts beat faster just watching you go!");
		//metric(kilometers)
		if (unit==0){
			if (bestlife.getLifeDistance()>21){
				accolades[3].setCheck(true);
			}
		}
		//imperial(miles) 
		else{
			if (bestlife.getLifeDistance()>13){
				accolades[3].setCheck(true);
		}

		accolades[4].setTitle("Marathon Completed");
		accolades[4].setDescription("You just ran a marathon! You may now cross an imaginary finish line in your head!");
		if (unit==0){
			if (bestlife.getLifeDistance()>42){
				accolades[3].setCheck(true);
			}
		}
		//imperial(miles) 
		else{
			if (bestlife.getLifeDistance()>26){
				accolades[3].setCheck(true);
		}

		accolades[5].setTitle("Cookie Monster");
		accolades[5].setDescription("You burned off as many calories as 40 cookies. You are one cookie that won’t crumble!");
		if (daily.getCalories()>=2000){
			accolades[5].setCheck(true);
		}
		accolades[6].setTitle("Great Wall Climbed");
		accolades[6].setDescription("You have virtually climbed the Great Wall of China by taking greater than 5268 steps, in one day. Gongxi! ");
		if (daily.getSteps()>=5268){
			accolades[6].setCheck(true);
		}
		accolades[7].setTitle("Laugh & Snicker");
		accolades[7].setDescription("You’re definitely you when you’re fit! You just burned off calories equivalent to 15 Snickers bar!");
		if (bestlife.getCalories()>=5000){
			accolades[7].setCheck(true);
		}
		accolades[8].setTitle("Can't Touch This");
		accolades[8].setDescription("You're so high up, even MC Hammer can't touch this. Your best floor count is higher than 15");
		if (bestlife.getBestFloor()()>=20){
			accolades[8].setCheck(true);
		}
		accolades[9].setTitle("Moves Like Jaguar");
		accolades[9].setDescription("You've got moves! Your fairly active minutes is higher than 120. Roar on!");
		if (daily.getFairlyActiveMins()>=120){
			accolades[9].setCheck(true);
		}
		accolades[10].setTitle("Text Champ");
		accolades[10].setDescription("You just burned off 500 calories, that is equivalent to almost 13 straight hours of texting, keep it going!");
		if (daily.getCalories()>=500){
			accolades[10].setCheck(true);
		}
		accolades[11].setTitle("Laugh Away");
		accolades[11].setDescription("Did you know that laughing burns calories? You just burned off 1000 calories, equivalent of 5 straight hours of laughing, now laugh a little while getting fit!");
		if (daily.getCalories()>=1000){
			accolades[11].setCheck(true);
		}
		accolades[12].setTitle("Bonjour Paris!");
		accolades[12].setDescription("You just climbed the Eiffel Tower with 1700 steps! Enjoy the view and grab a croissant after?");
		if (bestlife.getBeststep()>=1700){
			accolades[12].setCheck(true);
		}
		accolades[13].setTitle("You Beat Flash!");
		accolades[13].setDescription("Your light active minute is above average (90 minutes).Flash is jealous!");
		if (daily.getLightActiveMinutes()>=2000){
			accolades[13].setCheck(true);
		}
		accolades[14].setTitle("Space Party Time!");
		accolades[14].setDescription("Are you a star? Because you just made it to space with your step count!");
		if (bestLife.getLifeSteps()>=477714000){
			accolades[14].setCheck(true);
		}
		accolades[15].setTitle("Burn Baby Burn");
		accolades[15].setDescription("Damn!You just burned 6000 calories, thats how much an Olympian burns");
		if (daily.getCalories()>=6000){
			accolades[15].setCheck(true);
		}
		accolades[16].setTitle("Skydiving-Check");
		accolades[16].setDescription("Check skydiving off your Bucketlist! Your floor count is 1000, that's where you need to be to skydive");
		if (bestLife.getLifeFloors()>=1000){
			accolades[6].setCheck(true);
		}
		accolades[17].setTitle("Big Mac Burner");
		accolades[17].setDescription("You just burned the equivalence of 6 Big Macs,you got this!");
		if (daily.getCalories()>=3000){
			accolades[17].setCheck(true);
		}
		accolades[18].setTitle("You're A Hero");
		accolades[18].setDescription("You have 120 very active minutes. Now you can make the world a healthier place");
		if (daily.getVeryActiveMins()()>=2000){
			accolades[18].setCheck(true);
		}
		accolades[19].setTitle("Hiker Status Achieved");
		accolades[19].setDescription("With your step count, you have just climbed Mount Everest! Relax and enjoy the view");
		if (bestLife.getLifeSteps()>=58070){
			accolades[19].setCheck(true);
		}
	}
	public String getTitle(int index){
		return accolades[index].getTitle(); 
	}
	public String getDescription(int index){
		return accolades[index].getDescription();
	}
	public boolean getCheck(int index){
		return accolades[index].getCheck(); 
	}
}
