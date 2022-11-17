import java.util.ArrayList;
import java.util.Scanner;

public class Survey {
    public static void main(String[] args) {

        /**
         COMPLETE THIS CLASS AFTER ALL OTHER CLASSES ARE COMPLETED
         */

        /*
        Write a program that will get information from 3 participants and
        -Print information for each participant
        -Print how many participants were male
        -Print how many participants were female
        -Print the age of the youngest person
        -Print the age of the eldest person
         */

        Scanner scanner = new Scanner(System.in);
        ArrayList<Participant> participants = new ArrayList<>();
        int maxAge = 0, minAge = Integer.MAX_VALUE;

        // 1
        do {

            System.out.println(SurveyQuestions.askToJoin);
            String answer1 = scanner.nextLine();

            if (answer1.toLowerCase().startsWith("y")){
                // Getting current participant's name
                System.out.println(SurveyQuestions.askName);
                String name = scanner.nextLine();

                // Getting current participant's age
                System.out.println(SurveyQuestions.askAge);
                int age = scanner.nextInt();
                scanner.nextLine(); // cleaning the empty line

                // Finding the max and min age out of all participants
                if (age > maxAge) maxAge = age;
                if (age < minAge) minAge = age;

                // Getting current participant's gender
                System.out.println(SurveyQuestions.askGender);
                char gender = scanner.nextLine().toUpperCase().charAt(0);

                Participant participant = new Participant(name, age, gender);
                participants.add(participant);
                Participant.addParticipants();

                if (gender == 'M') Participant.addMaleParticipants();
                else Participant.addFemaleParticipants();
            }

        }while (Participant.totalNumberOfParticipants < 3);

        /*
        THE END RESULT OF ABOVE SURVEY
        Participant {name: ‘Alex’, age: 25, gender: ‘M’}
        Participant {name: ‘Jennifer’, age: 18, gender: ‘F’]
        Participant {name: ‘Jessica’, age: 59, gender: ‘F’]
        The total number of male participants is = 1
        The total number of female participants is = 2
        The age of the youngest person is = 18
        The age of the eldest person is = 59
         */

        for (Participant p : participants) System.out.println(p);

        System.out.println("The total number of male participants is = " + Participant.totalNumberOfMaleParticipants);
        System.out.println("The total number of female participants is = " + Participant.totalNumberOfFemaleParticipants);

        System.out.println("The age of the youngest person is = " + minAge);
        System.out.println("The age of the eldest person is = " + maxAge);
    }
}