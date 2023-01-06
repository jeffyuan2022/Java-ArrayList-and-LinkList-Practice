
class UpperCaseTransformer implements MyTransformer<String> {

	public String transformElement(String s) {
		return s.toUpperCase();
	}

}

// Add your transformers here
class lengthCaseTransformer implements MyTransformer<String> {

	public String transformElement(String s) {
		return String.valueOf(s.length());
	}
	
}

class firstThreeLetterCaseTransformer implements MyTransformer<String> {

	public String transformElement(String s) {
		if(s.length() > 3) {
			return s.substring(0,3);
		}
		return s;
	}
	
}