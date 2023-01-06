
class LongWordChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return s.length() > 5;
	}

} 

// Add your choosers here

class containVowelsChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return (s.contains("a")||s.contains("e")||s.contains("i")||
				s.contains("o")||s.contains("u")||s.contains("A")||
				s.contains("E")||s.contains("I")||s.contains("O")||
				s.contains("U"));
	}

} 

class startWithAChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return (s.startsWith("a")||s.startsWith("A"));
	}

} 