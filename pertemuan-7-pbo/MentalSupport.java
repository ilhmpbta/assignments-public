import java.util.Map;  
import java.util.HashMap;  
import java.util.Random;
import java.util.Scanner;

public class MentalSupport {
    private Map<String, String> supportMessages;
    private Random random;

    public MentalSupport() {
        supportMessages = new HashMap<>();
        random = new Random();
        supportMessages.put("sad", "Sadness is a part of life. It's okay to feel sad sometimes. Remember, after the rain comes the rainbow.");
        supportMessages.put("happy", "That's great to hear! Keep spreading the positivity and joy around you.");
        supportMessages.put("anxious", "You can overcome anxiety. Try deep breathing exercises and focus on the present moment.");
        supportMessages.put("stressed", "Take a break and do something you enjoy. Remember, your mental health is important.");
        supportMessages.put("lonely", "You are not alone. Reach out to friends, family, or support groups. There are people who care about you.");
        supportMessages.put("angry", "It's okay to feel angry sometimes. Try to channel that energy into something productive, like exercise or a creative activity.");
        supportMessages.put("tired", "Make sure to get enough rest and take care of yourself. Your well-being is important.");
        supportMessages.put("confused", "It's okay to feel confused. Take your time to think things through and seek advice from trusted friends or mentors.");
        supportMessages.put("depressed", "If you're feeling depressed, it's important to reach out for help. Talk to a mental health professional or someone you trust.");
        supportMessages.put("hanging", "If you're feeling like this, please reach out to a mental health professional or someone you trust. You don't have to face this alone.");
        supportMessages.put("overwhelmed", "If you're feeling overwhelmed, try to break things down into smaller, manageable tasks. It's okay to ask for help.");
        supportMessages.put("thank", "You're welcome! Remember, taking care of your mental health is important. Don't hesitate to reach out if you need support.");
    }

    public String getResponses(String userInput){
        String[] words = userInput.toLowerCase().split("\\s+");  
            for (String w : words) {  
            if (supportMessages.containsKey(w)) {  
                return supportMessages.get(w);  
            }  
        }
        String[] generic = {  
            "I'm here for you. Remember, you're not alone.",
            "Take a deep breath. Everything will be okay.",
            "It's okay to take a break and focus on yourself.",
            "Focus on the positive aspects of your life.",
        };  
        return generic[random.nextInt(generic.length)];  
    }

    public String getInput(String userInput) {
        return userInput;
    }
    public static void main(String[] args) {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm here to provide you with some mental support.");
        System.out.println("How are you feeling today? (type 'exit' to quit)");
        MentalSupport ms = new MentalSupport();
        userInput = "";
        while(!userInput.equals("exit")){
            System.out.print("You: ");
            userInput = scanner.nextLine();
            if(userInput.equalsIgnoreCase("exit")) {
                System.out.println("Mental Support: Take care! Remember, you're not alone.");
                break;
            }
            System.out.println("Mental Support: " + ms.getResponses(userInput));
        }

        scanner.close();
    }

}