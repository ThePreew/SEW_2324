package Übung;

import javafx.collections.transformation.SortedList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Übung{
    public static void main(String[] args) {
        System.out.println(zahlHoch(0,10));
        System.out.println(coinSums(100,0));
        System.out.println(collatzSequenceLength(13,0));
        System.out.println(isIP("1.1.1.1"));
        System.out.println(isNumber(".e234"));
    }

    public static int zahlHoch(int x, int n){
        if(n==1) {
            return x;
        }
        if(n%2==0){
            return zahlHoch(x,n/2)*zahlHoch(x,n/2);
        }
        return x*zahlHoch(x,(n-1)/2)*zahlHoch(x,(n-1)/2);
    }

    public static long coinSums(int target, int coinIndex) {
        int[] coinValues = {1, 2, 5, 10, 20, 50, 100, 200};
        if (target == 0) {
            return 1;
        }
        if (target < 0 || coinIndex >= coinValues.length) {
            return 0;
        }

        long includeCurrentCoin = coinSums(target - coinValues[coinIndex], coinIndex);
        long excludeCurrentCoin = coinSums(target, coinIndex + 1);
        return includeCurrentCoin + excludeCurrentCoin;
    }

    public static int collatzSequenceLength(long n, int length) {
        if (n==1){
            return length;
        }
        if(n%2==0){
            return collatzSequenceLength(n/2,length+1);
        }
        return collatzSequenceLength((3*n)+1,length+1);
    }

    public static boolean isIP(String ip){
        Pattern pattern=Pattern.compile("^([0-1]?[0-9]?[0-9]|[2][0-4][0-9]|[2][5][0-5])\\.([0-1]?[0-9]?[0-9]|[2][0-4][0-9]|[2][5][0-5])\\.([0-1]?[0-9]?[0-9]|[2][0-4][0-9]|[2][5][0-5])\\.([0-1]?[0-9]?[0-9]|[2][0-4][0-9]|[2][5][0-5])$");
        return ip.matches(String.valueOf(pattern));
    }

    public static boolean isNumber(String n){
        return n.matches("-?([0-9]*)?(\\.[0-9]*([e]-[0-9]*)?)?");
    }

    public static Set<String> SysLogA(Path path) throws IOException {
        Set<String> treeset = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        List<String> lines = Files.readAllLines(path);
        Pattern patter = Pattern.compile("\\d\\d:\\d\\d:\\d\\d:[a0]");
        for (String line : lines) {
            Matcher matcher = patter.matcher(line);
            if (matcher.find()) {
                treeset.add(matcher.group());
            }
        }
        return treeset;
    }
}


