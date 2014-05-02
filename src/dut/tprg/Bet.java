package dut.tprg;

public class Bet {
	
	private int bet_amount ;
	private String bet_choice ;
	private int bet_num ;

	private int spin_result ;

	public Bet(int amount, String choice) {
		bet_amount = amount ;
		bet_choice = choice ;
		spin_result = doSpin() ;
	}

	private int doSpin() {
		return (int) Math.floor(36*Math.random()+1);
	}

	public int getSpinResult() {
		return spin_result;
	}

	public String getSpinColor() {
		if(spin_result %2 == 0) {
			return "red";
		}
		else {
			return "black";
		}
	}

	public boolean didWeWin() {
		switch(bet_choice) {
			case "black":
			case "red":
				String spin_color = getSpinColor();
				if(bet_choice.equals(spin_color)) {
					return true;
				} else {
					return false;
				}
			default:
				// the bet was a number
				bet_num = Integer.parseInt(bet_choice);
				if(bet_num == spin_result) {
					return true;
				} else {
					return false; 
				}
		}
	}

	public int getPayout() {
		// if we didn't win..we lose the amount we bet
		if(!didWeWin()) {
			return -bet_amount;
		}
		switch(bet_choice) {
			case "black":
			case "red":
				return 2*bet_amount;
			default:
				return 36*bet_amount;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			Bet b = new Bet(10,"red");
			System.out.println("Bet - getSpinResult:"+b.getSpinResult());
			System.out.println("Bet - getSpinColor:"+b.getSpinColor());
			System.out.println("Bet - didWeWin:"+b.didWeWin());
			System.out.println("Bet - getPayout:"+b.getPayout());
		}

		for(int i=0;i<50;i++) {
			Bet b = new Bet(10,"5");
			System.out.println("Bet - getSpinResult:"+b.getSpinResult());
			System.out.println("Bet - getSpinColor:"+b.getSpinColor());
			System.out.println("Bet - didWeWin:"+b.didWeWin());
			System.out.println("Bet - getPayout:"+b.getPayout());
			b = new Bet(10,"36");
			System.out.println("Bet - getSpinResult:"+b.getSpinResult());
			System.out.println("Bet - getSpinColor:"+b.getSpinColor());
			System.out.println("Bet - didWeWin:"+b.didWeWin());
			System.out.println("Bet - getPayout:"+b.getPayout());
		}

	}

}
