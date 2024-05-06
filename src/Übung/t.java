package Übung;

import java.util.Random;


public class t {
    public static void main(String[] args) {
        Generator("Warwick");
    }

    public static void Generator(String Champion){
        Random random = new Random();
        int randomInteger = random.nextInt(5) + 0;
        String[] Quote=new String[] {"You're right, " +Champion+". I'm you. I wanted to reject you, convince myself that you were wrong. But that doesn't matter now. I'm gonna kill you. Even if you come back as another Champion, I'll kill you. Change your name. Change your form. I'll kill you again. I don't need to find meaning or a reason. Maybe in a hundred years after my death, the meaning behind my actions will become apparent. In the grand scheme of things... I'm probably nothing more than a cog. But I'll keep killing champions... for as long as I can. That's my role in all this.", "Stand proud " + Champion + ", you were weak.", "Are you gay because you are " +Champion + " or are you " + Champion + " because you are gay?","Throughout Heavean and Eearth, you are the Fraudulent one.", "The only reason you were the Strongest Champion, was simply because I wasnt born yet."};
        System.out.println(Quote[randomInteger]);
    }

}