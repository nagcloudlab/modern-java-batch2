package patterns.strategy.oo;

interface ValidationStrategy {
	boolean execute(String s);
}

class Validator {
	private ValidationStrategy strategy;

	public void setValidationStrategy(ValidationStrategy validationStrategy) {
		this.strategy = validationStrategy;
	}

	public boolean validate(String s) {
		// .....
		return strategy.execute(s);
	}
}

class NumericValidationStrategy implements ValidationStrategy {
	@Override
	public boolean execute(String s) {
		return s.matches("\\d+");
	}
}

class AlphabetValidationStrategy implements ValidationStrategy {
	@Override
	public boolean execute(String s) {
		return s.matches("[A-Za-z]+");
	}
}

public class App {

	public static void main(String[] args) {

		Validator validator = new Validator();
		
		validator.setValidationStrategy(new NumericValidationStrategy());
		boolean boo = validator.validate("1234");
		System.out.println(boo);

		
		validator.setValidationStrategy(new AlphabetValidationStrategy());
		boo=validator.validate("abcd1");
		System.out.println(boo);

	}

}
