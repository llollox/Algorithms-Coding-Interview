package com.llollox.algorithms.problems.unitn.greedy;

import com.llollox.algorithms.problems.unitn.models.Interval;

import java.util.*;

public class MaxNumIntervals {

    /*
        Sottoinsieme degli interventi di cardinalità massima

        1) Verifico che l'array non sia null o vuoto
        2) Ordino gli intervalli per ordine di fine
            - Salvando il massimo end

        3) Scorro tutti i valori dallo start del primo ad end
            Sposto t alla fine dell'intervallo scelto.
            Aggiungo l'intervallo alla lista

        4) Ritorno la lista.

     */


    public List<Interval> maxInterval(Interval[] intervals) {
        // Intervalli ordinati per data di fine.

        ArrayList<Interval> list = new ArrayList<>();

        if (intervals == null || intervals.length == 0) {
            return list;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                return Integer.compare(interval1.end, interval2.end);
            }
        });

        int end = intervals[intervals.length -1].end;

        int t = intervals[0].start;

        while (t <= end) {

            Interval intervalFound = null;

            for (Interval interval : intervals) {
                if (interval.start == t) {
                    intervalFound = interval;
                    break;
                }
            }

            if (intervalFound == null) {
                t = t + 1;
            }
            else {
                list.add(intervalFound);
                t = intervalFound.end;
            }
        }

        return list;
    }
}
