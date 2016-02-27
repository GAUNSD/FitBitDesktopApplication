package ca.uwo.csd.cs2212.team10;

public class DailyStats {
	
		private int floors;
		private int steps;
		private double distance;
		private int calories;
		private int sedentaryMins;
		private int lightActiveMins;
		private int fairlyActiveMins;
		private int veryActiveMins;
	
		public DailyStats (int floors, int steps,double distance, int calories, int sedentaryMins, 
							int lightActiveMins, int fairlyActiveMins, int veryActiveMins)
		{
			
			this.floors = floors;
			this.steps = steps;
			this.distance= distance;
			this.calories = calories;
			this.sedentaryMins= sedentaryMins;
			this.lightActiveMins= lightActiveMins;
			this.fairlyActiveMins= fairlyActiveMins;
			this.veryActiveMins=veryActiveMins;
		}
		
		public String toString(){
			return "Daily Stats["+"floors = "+this.floors+ ", steps = " + this.steps + ", distance = "+ 
					this.distance + ", calories = " + this.calories + ", sedentaryMins = " + this.sedentaryMins + ", lightActiveMins" + 
					this.lightActiveMins + ", fairlyActiveMins" + this.fairlyActiveMins + ", veryActiveMins = " +
					this.veryActiveMins;	 
		}
			

		public int getFloors() {
			return floors;
		}

		public int getSteps() {
			return steps;
		}

		public double getDistance() {
			return distance;
		}
		
		public int getCalories() {
			return calories;
		}

		public int getSedentaryMins() {
			return sedentaryMins;
		}

		public int getLightActiveMins() {
			return lightActiveMins;
		}

		public int getFairlyActiveMins() {
			return fairlyActiveMins;
		}

		public int getVeryActiveMins() {
			return veryActiveMins;
		}
}
