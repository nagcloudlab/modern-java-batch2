package patterns.strategy.fp;

@FunctionalInterface
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

public class App {

	public static void main(String[] args) {

		Validator validator = new Validator();
		
		validator.setValidationStrategy(s->s.matches("[0-9]+"));
		boolean boo = validator.validate("1234");
		System.out.println(boo);

		
		validator.setValidationStrategy((s->s.matches("[a-z]+")));
		boo=validator.validate("abcd");
		System.out.println(boo);

	}

}
