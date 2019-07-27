package previmedical.it.leetcode.problems.crack.moderate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LivingPeople {

    /*
        Given a list of people with their birth and death years,
        implement a method to compute the year with the most number of people alive.

        You may assume that all people were born between 1900 and 2000 (inclusive).
        If a person was alive during any portion of that year,
        they should be included in that year's count.
        For example, Person (birth= 1908, death= 1909) is included in the counts for both 1908 and 1909.
     */


    /*

        Solution 1. (Forza bruta)  T: O(n * k) S: O(k)
        Creo una mappa da 1 a 100.
        Per ogni persona,
            per ogni anno che è stata viva:
                incremento il valore nella mappa
                tengo conto del max



        Solution 1.

        Array di 101 valori interi
        Per tutte le persone, per tutti gli anni di vita, vado ad incrementare il valore di 1 nell'array con indice (anno - 1900)
        Alla fine scorro l'array e ritorno il massimo.

        Ottimizzazione, tenere conto del massimo mentre inserisco i valori nell'array.
        Evito in questo modo l'ultimo passaggio.

        Complessità: n = #persone, k=100, durata massima di una persona
        O(n * k) S(k+1)


        Solution 2.
        Ordino gli intervalli per data di inizio
        Scorro tutti gli anni dall'inizio del primo alla fine dell'ultimo. Per ognuno:
            - calcolo quante persone sono in vita in quell'anno
                - È chiaro che quando appena trovo la prima persona nata dopo l'anno che sto cercando mi fermo.
            - tengo traccia del massimo


        Solution 3.
        T: O(n*log(n) + n) S: O(1)
        Ordino le persone per data di nascita.
        Scorro le persone con due indici: la prima persona e l'ultima che prendo in considerazione.
            - Questi due indici mi servono per calcolare il prossimo che muore senza dover scorrere tutto l'array
            - Calcolo il min tra la prossima persona che muore e la prima persona che nasce.
            - Sposto year su min
            - Se la prossima persona muore
                - Incremento min e decremento il numero di persone vive
            - Se la prossima persona nasce
                - Incremento max e incremento il numero di persone vive
            - Tutto ciò tenendo traccia del max


        Per ogni persona con due intervalli
        Per ogni anno:
            - scorro gli intervalli con due indici contanto quanti rispettano il pattern.
            - quando year < interval.start, esco dal ciclo in quanto tutti i successivi saranno più grandi.

        1  2  3  4  5  6  7  8  9  10
        -------
           -------
           ----------
              -------
                 ---------
                 --------------------
                    ---
                      -------

     */

    public static class Person {
        int birth;
        int death;

        public Person(int birth, int dead) {
            this.birth = birth;
            this.death = dead;
        }
    }


    // -----------------------------------------------------------------------------------------------------------------
    // T: O(n * k) S: O(k)
    public int bruteForce(Person[] people) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxPeopleAlive = 0;
        int yearWithMostPeopleAlive = -1;

        for (Person person : people) {

            for (int year = person.birth; year<=person.death; year++) {
                int numPeopleAlive = (map.get(year) == null ? 0 : map.get(year)) + 1;

                if (numPeopleAlive > maxPeopleAlive) {
                    maxPeopleAlive = numPeopleAlive;
                    yearWithMostPeopleAlive = year;
                }

                map.put(year, numPeopleAlive);
            }
        }

        return yearWithMostPeopleAlive;
    }


    // -----------------------------------------------------------------------------------------------------------------
    // O:(n * log(n) + k * n) S: O(1)
    public int sorted(Person[] people) {

        // Edge case
        if (people == null || people.length == 0) {
            return -1;
        }

        // People sorted by birth year
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.birth, p2.birth);
            }
        });

        int start = people[0].birth;
        int end = people[people.length - 1].death;

        int maxNumAlivePeople = 0;
        int yearWithMostPeopleAlive = -1;

        for (int year=start; year<=end; year++) {

            int numAlivePeople = getNumAlivePeople(year, people);

            if (numAlivePeople > maxNumAlivePeople) {
                maxNumAlivePeople = numAlivePeople;
                yearWithMostPeopleAlive = year;
            }
        }

        return yearWithMostPeopleAlive;
    }

    // T: O(n) S: O(1)
    private int getNumAlivePeople(int year, Person[] people) {
        int count = 0;
        for (Person person: people) {

            if (person.birth <= year && year <= person.death) {
                count = count + 1;
            }
            else if (person.birth > year) {
                return count;
            }
        }
        return count;
    }


    // -----------------------------------------------------------------------------------------------------------------
    // T: O(n * log(n) + k * log(n)) S: O(n)
    public int optimum(Person[] people) {

        // Corner cases
        if (people == null || people.length == 0) {
            return -1;
        }

        // Sort people by birth
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.birth, p2.birth);
            }
        });

        int max = 0;

        int maxNumAlivePeople = 1;
        int yearWithMostAlivePeople = people[0].birth;

        PriorityQueue<Person> peopleDeathQueye = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.death, p2.death);
            }
        });

        peopleDeathQueye.add(people[0]);

        while (max < people.length) {  // K

            int yearOfNextDeath = yearOfNextDeath(peopleDeathQueye);  // O(1)
            int yearOfNextBirth = yearOfNextBirth(people, max);         // O(1)

            if (yearOfNextBirth <= yearOfNextDeath) {

                max = max + 1;

                peopleDeathQueye.add(people[max]);      // O(log n)

                int numAlivePeople = peopleDeathQueye.size();  // O(1)

                if (numAlivePeople > maxNumAlivePeople) {
                    maxNumAlivePeople = numAlivePeople;
                    yearWithMostAlivePeople = yearOfNextBirth;
                }

                // If the number of alive people left to reach max is greater than the people left to be considered,
                // there is no possibility to reach maximum again and therefore return
                if (maxNumAlivePeople - numAlivePeople > people.length - max ) {
                    return yearWithMostAlivePeople;
                }
            }
            else {
                peopleDeathQueye.poll();  // O(log n)

                if (max == people.length - 1) {
                    max = max + 1;
                }
            }
        }

        return yearWithMostAlivePeople;
    }


    // T: O(1) S: O(1)
    private int yearOfNextDeath(PriorityQueue<Person> queue) {
        return queue.isEmpty() ? Integer.MAX_VALUE : queue.peek().death;
    }

    // T: O(1) S: O(1)
    private int yearOfNextBirth(Person[] people, int max) {
        return max < people.length - 1 ? people[max + 1].birth : Integer.MAX_VALUE;
    }

}
