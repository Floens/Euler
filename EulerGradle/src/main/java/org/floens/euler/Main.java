package org.floens.euler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.floens.euler.math.PrimeFinder;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    private void log(Object obj) {
        System.out.println(obj.toString());
    }

    private void logList(List<?> list) {
        log(StringUtils.join(list, ","));
    }

    private void logArray(Object[] arr) {
        log(Arrays.toString(arr));
    }

    private void problem6() {
        List<Long> list = new ArrayList<>();

        long squareSum = 0;
        for (int i = 1; i <= 100; i++) {
            squareSum += i * i;
        }

        log(squareSum);

        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }

        log(sum * sum);

        log((sum * sum) - squareSum);
    }

    private void problem7() {
        List<Long> list = new ArrayList<>(1000);

        for (long i = 2; true; i++) {
            boolean flag = false;
            for (long a = i - 1; a > 1; a--) {
                if (i % a == 0) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                continue;
            }

            list.add(i);
            if (list.size() >= 10001) {
                break;
            }
        }

        log(StringUtils.join(list, ","));
    }

    private List<Long> getPrimes(long max) {
        long lastTime = System.currentTimeMillis();

        List<Long> list = new ArrayList<>();

        for (long i = 2; i < max; i++) {
            if (isPrime(i)) {
                list.add(i);
            }

            if (System.currentTimeMillis() - lastTime > 1000L) {
                lastTime = System.currentTimeMillis();
                log("Now at " + i);
            }
        }

        return list;
    }

    private boolean isPrime(long n) {
        if (n % 2 == 0)
            return false;

        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private void problem8() {
        String numbers = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";

        long max = 0;
        for (int i = 0; i < numbers.length() - 13; i++) {
            String sub = numbers.substring(i, i + 13);
            long a = 1;
            for (int j = 0; j < sub.length(); j++) {
                a *= Long.parseLong("" + sub.charAt(j));
                if (a > max) {
                    max = a;
                }
            }
        }

        log(max);
    }

    private void problem9() {
        long a = 0;
        long b = 0;
        long c = 0;

        for (a = 0; a < 1000; a++) {
            for (b = a + 1; b < 1000; b++) {
                for (c = b + 1; c < 1000; c++) {
                    if (a * a + b * b == c * c) {
                        if (a + b + c == 1000) {
                            log(a + "," + b + ", " + c);
                            log("Product: " + (a * b * c));
                        }
                    }
                }
            }
        }
    }

    private void problem10() {
        List<Long> primes = getPrimes(2000000L);

        long sum = 0;
        for (long prime : primes) {
            sum += prime;
        }

        log(sum);
    }

    private void problem11() {
        int[][] grid = new int[][] {
                { 8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50,
                        77, 91, 8 },
                { 49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69,
                        48, 4, 56, 62, 0 },
                { 81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30,
                        3, 49, 13, 36, 65 },
                { 52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71,
                        37, 2, 36, 91 },
                { 22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40,
                        28, 66, 33, 13, 80 },
                { 24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20,
                        35, 17, 12, 50 },
                { 32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70,
                        66, 18, 38, 64, 70 },
                { 67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91,
                        66, 49, 94, 21 },
                { 24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14,
                        88, 34, 89, 63, 72 },
                { 21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97,
                        34, 31, 33, 95 },
                { 78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14,
                        9, 53, 56, 92 },
                { 16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24,
                        36, 29, 85, 57 },
                { 86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58,
                        51, 54, 17, 58 },
                { 19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17,
                        77, 4, 89, 55, 40 },
                { 4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79,
                        33, 27, 98, 66 },
                { 88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12,
                        32, 63, 93, 53, 69 },
                { 4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32,
                        40, 62, 76, 36 },
                { 20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59,
                        85, 74, 4, 36, 16 },
                { 20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81,
                        16, 23, 57, 5, 54 },
                { 1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1,
                        89, 19, 67, 48 } };

        int sum = 0, x, y;
        for (x = 0; x < 24; x++) {
            for (y = 0; y < 24; y++) {
                final int xx = x;
                final int yy = y;
                int tx;
                int ty;
                int ss;

                // diagonal to the bottom right
                ss = 1;
                tx = xx;
                ty = yy;
                for (int i = 0; i < 4; i++) {
                    ss *= problem11getGrid(grid, tx, ty);
                    tx++;
                    ty++;
                }

                if (ss > sum) {
                    sum = ss;
                }

                // diagonal to the top right
                ss = 1;
                tx = xx;
                ty = yy;
                for (int i = 0; i < 4; i++) {
                    ss *= problem11getGrid(grid, tx, ty);
                    tx++;
                    ty--;
                }

                if (ss > sum) {
                    sum = ss;
                }

                // to the right
                ss = 1;
                tx = xx;
                ty = yy;
                for (int i = 0; i < 4; i++) {
                    ss *= problem11getGrid(grid, tx, ty);
                    tx++;
                }

                if (ss > sum) {
                    sum = ss;
                }

                // to the bottom
                ss = 1;
                tx = xx;
                ty = yy;
                for (int i = 0; i < 4; i++) {
                    ss *= problem11getGrid(grid, tx, ty);
                    ty++;
                }

                if (ss > sum) {
                    sum = ss;
                }
            }
        }

        log(sum);
    }

    private int problem11getGrid(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= 20 || y >= 20)
            return 1;
        return grid[x][y];
    }

    private void problem12() {
        int i = 2;
        long count = 0;
        long trian = 0;
        while (true) {
            log(i);
            trian = getTriangleNumber(i);
            count = getFactorsCount(trian);

            log("trian: " + trian + ", count: " + count);

            if (count > 500) {
                log(StringUtils.join(getFactors(trian), ","));
                log("here: " + trian);
                break;
            }

            i++;
        }
    }

    private long getTriangleNumber(long n) {
        long v = 0;
        for (int i = 0; i <= n; i++) {
            v += i;
        }
        return v;
    }

    private long getFactorsCount(long n) {
        int nod = 0;

        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                nod += 2;
            }
        }

        return nod;
    }

    private List<Long> getFactors(long n) {
        List<Long> list = new ArrayList<>();

        for (long i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }

        return list;
    }

    private List<Long> getPrimeFactors(long n) {
        List<Long> list = new ArrayList<>();

        long d = 2;
        while (n > 1) {
            while (n % d == 0) {
                list.add(d);
                n = n / d;
            }
            d++;
        }

        return list;
    }

    private void problem13() {
        BigInteger[] map = { new BigInteger("37107287533902102798797998220837590246510135740250"),
                new BigInteger("46376937677490009712648124896970078050417018260538"),
                new BigInteger("74324986199524741059474233309513058123726617309629"),
                new BigInteger("91942213363574161572522430563301811072406154908250"),
                new BigInteger("23067588207539346171171980310421047513778063246676"),
                new BigInteger("89261670696623633820136378418383684178734361726757"),
                new BigInteger("28112879812849979408065481931592621691275889832738"),
                new BigInteger("44274228917432520321923589422876796487670272189318"),
                new BigInteger("47451445736001306439091167216856844588711603153276"),
                new BigInteger("70386486105843025439939619828917593665686757934951"),
                new BigInteger("62176457141856560629502157223196586755079324193331"),
                new BigInteger("64906352462741904929101432445813822663347944758178"),
                new BigInteger("92575867718337217661963751590579239728245598838407"),
                new BigInteger("58203565325359399008402633568948830189458628227828"),
                new BigInteger("80181199384826282014278194139940567587151170094390"),
                new BigInteger("35398664372827112653829987240784473053190104293586"),
                new BigInteger("86515506006295864861532075273371959191420517255829"),
                new BigInteger("71693888707715466499115593487603532921714970056938"),
                new BigInteger("54370070576826684624621495650076471787294438377604"),
                new BigInteger("53282654108756828443191190634694037855217779295145"),
                new BigInteger("36123272525000296071075082563815656710885258350721"),
                new BigInteger("45876576172410976447339110607218265236877223636045"),
                new BigInteger("17423706905851860660448207621209813287860733969412"),
                new BigInteger("81142660418086830619328460811191061556940512689692"),
                new BigInteger("51934325451728388641918047049293215058642563049483"),
                new BigInteger("62467221648435076201727918039944693004732956340691"),
                new BigInteger("15732444386908125794514089057706229429197107928209"),
                new BigInteger("55037687525678773091862540744969844508330393682126"),
                new BigInteger("18336384825330154686196124348767681297534375946515"),
                new BigInteger("80386287592878490201521685554828717201219257766954"),
                new BigInteger("78182833757993103614740356856449095527097864797581"),
                new BigInteger("16726320100436897842553539920931837441497806860984"),
                new BigInteger("48403098129077791799088218795327364475675590848030"),
                new BigInteger("87086987551392711854517078544161852424320693150332"),
                new BigInteger("59959406895756536782107074926966537676326235447210"),
                new BigInteger("69793950679652694742597709739166693763042633987085"),
                new BigInteger("41052684708299085211399427365734116182760315001271"),
                new BigInteger("65378607361501080857009149939512557028198746004375"),
                new BigInteger("35829035317434717326932123578154982629742552737307"),
                new BigInteger("94953759765105305946966067683156574377167401875275"),
                new BigInteger("88902802571733229619176668713819931811048770190271"),
                new BigInteger("25267680276078003013678680992525463401061632866526"),
                new BigInteger("36270218540497705585629946580636237993140746255962"),
                new BigInteger("24074486908231174977792365466257246923322810917141"),
                new BigInteger("91430288197103288597806669760892938638285025333403"),
                new BigInteger("34413065578016127815921815005561868836468420090470"),
                new BigInteger("23053081172816430487623791969842487255036638784583"),
                new BigInteger("11487696932154902810424020138335124462181441773470"),
                new BigInteger("63783299490636259666498587618221225225512486764533"),
                new BigInteger("67720186971698544312419572409913959008952310058822"),
                new BigInteger("95548255300263520781532296796249481641953868218774"),
                new BigInteger("76085327132285723110424803456124867697064507995236"),
                new BigInteger("37774242535411291684276865538926205024910326572967"),
                new BigInteger("23701913275725675285653248258265463092207058596522"),
                new BigInteger("29798860272258331913126375147341994889534765745501"),
                new BigInteger("18495701454879288984856827726077713721403798879715"),
                new BigInteger("38298203783031473527721580348144513491373226651381"),
                new BigInteger("34829543829199918180278916522431027392251122869539"),
                new BigInteger("40957953066405232632538044100059654939159879593635"),
                new BigInteger("29746152185502371307642255121183693803580388584903"),
                new BigInteger("41698116222072977186158236678424689157993532961922"),
                new BigInteger("62467957194401269043877107275048102390895523597457"),
                new BigInteger("23189706772547915061505504953922979530901129967519"),
                new BigInteger("86188088225875314529584099251203829009407770775672"),
                new BigInteger("11306739708304724483816533873502340845647058077308"),
                new BigInteger("82959174767140363198008187129011875491310547126581"),
                new BigInteger("97623331044818386269515456334926366572897563400500"),
                new BigInteger("42846280183517070527831839425882145521227251250327"),
                new BigInteger("55121603546981200581762165212827652751691296897789"),
                new BigInteger("32238195734329339946437501907836945765883352399886"),
                new BigInteger("75506164965184775180738168837861091527357929701337"),
                new BigInteger("62177842752192623401942399639168044983993173312731"),
                new BigInteger("32924185707147349566916674687634660915035914677504"),
                new BigInteger("99518671430235219628894890102423325116913619626622"),
                new BigInteger("73267460800591547471830798392868535206946944540724"),
                new BigInteger("76841822524674417161514036427982273348055556214818"),
                new BigInteger("97142617910342598647204516893989422179826088076852"),
                new BigInteger("87783646182799346313767754307809363333018982642090"),
                new BigInteger("10848802521674670883215120185883543223812876952786"),
                new BigInteger("71329612474782464538636993009049310363619763878039"),
                new BigInteger("62184073572399794223406235393808339651327408011116"),
                new BigInteger("66627891981488087797941876876144230030984490851411"),
                new BigInteger("60661826293682836764744779239180335110989069790714"),
                new BigInteger("85786944089552990653640447425576083659976645795096"),
                new BigInteger("66024396409905389607120198219976047599490197230297"),
                new BigInteger("64913982680032973156037120041377903785566085089252"),
                new BigInteger("16730939319872750275468906903707539413042652315011"),
                new BigInteger("94809377245048795150954100921645863754710598436791"),
                new BigInteger("78639167021187492431995700641917969777599028300699"),
                new BigInteger("15368713711936614952811305876380278410754449733078"),
                new BigInteger("40789923115535562561142322423255033685442488917353"),
                new BigInteger("44889911501440648020369068063960672322193204149535"),
                new BigInteger("41503128880339536053299340368006977710650566631954"),
                new BigInteger("81234880673210146739058568557934581403627822703280"),
                new BigInteger("82616570773948327592232845941706525094512325230608"),
                new BigInteger("22918802058777319719839450180888072429661980811197"),
                new BigInteger("77158542502016545090413245809786882778948721859617"),
                new BigInteger("72107838435069186155435662884062257473692284509516"),
                new BigInteger("20849603980134001723930671666823555245252804609722"),
                new BigInteger("53503534226472524250874054075591789781264330331690") };

        BigInteger total = map[0];

        for (int i = 1; i < map.length; i++) {
            total = total.add(map[i]);
        }

        log(total.toString().substring(0, 10));
    }

    private List<Long> makeCollatzChain(long start) {
        List<Long> list = new ArrayList<>();

        list.add(start);

        while (true) {
            if (start % 2 == 0) {
                start = start / 2;
            } else {
                start = 3 * start + 1;
            }

            list.add(start);

            if (start <= 1) {
                break;
            }
        }

        return list;
    }

    private void problem14() {
        List<Long> chain;
        int longest = 0;
        long longestStart = 0;
        for (long i = 0; i < 1e6; i++) {
            chain = makeCollatzChain(i);
            if (chain.size() > longest) {
                longest = chain.size();
                longestStart = i;
                logList(chain);
            }
        }

        log(longestStart);
    }

    private void problem15() {
        final int gridSize = 20 + 1;

        long[][] grid = new long[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            grid[i][gridSize - 1] = 1L;
            grid[gridSize - 1][i] = 1L;
        }

        for (int x = gridSize - 2; x >= 0; x--) {
            for (int y = gridSize - 2; y >= 0; y--) {
                grid[x][y] = grid[x + 1][y] + grid[x][y + 1];
            }
        }

        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                System.out.print(grid[x][y] + ",");
            }
            System.out.print('\n');
        }
        System.out.flush();

        long routes = grid[0][0];

        log("Routes " + routes);
    }

    private void problem16() {
        BigInteger start = BigInteger.valueOf(2);
        BigInteger raised = start.pow(1000);

        String string = raised.toString();
        log(string);

        long total = 0;
        for (int i = 0; i < string.length(); i++) {
            total += Integer.parseInt(String.valueOf(string.charAt(i)));
        }

        log(total);
    }

    private void problem18() {
        String[] triangle = {
                "75",
                "95 64",
                "17 47 82",
                "18 35 87 10",
                "20 04 82 47 65",
                "19 01 23 75 03 34",
                "88 02 77 73 07 63 67",
                "99 65 04 28 06 16 70 92",
                "41 41 26 56 83 40 80 70 33",
                "41 48 72 33 47 32 37 16 94 29",
                "53 71 44 65 25 43 91 52 97 51 14",
                "70 11 33 28 77 73 17 78 39 68 17 57",
                "91 71 52 38 17 14 91 43 58 50 27 29 48",
                "63 66 04 68 89 53 67 30 73 16 69 87 40 31",
                "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23" };

        int[][] parsed = new int[triangle.length][];

        for (int i = 0; i < triangle.length; i++) {
            List<Integer> row = new ArrayList<>();
            String[] splitted = triangle[i].split(" ");

            parsed[i] = new int[splitted.length];

            for (int j = 0; j < splitted.length; j++) {
                parsed[i][j] = Integer.parseInt(splitted[j]);
            }
        }

        int a, b, c;
        for (int i = parsed.length - 2; i >= 0; i--) {
            for (int j = 0; j < parsed[i].length; j++) {
                c = parsed[i][j];
                a = parsed[i + 1][j];
                b = parsed[i + 1][j + 1];
                parsed[i][j] = a > b ? c + a : c + b;
            }
        }

        log(parsed[0][0]);
    }

    private void problem19() {
        int year = 1900;
        int month = 0;
        int day = 0;
        int sundays = 0;

        while (true) {
            if (year >= 1901 && day % 7 == 6) {
                sundays++;
            }

            if (month == 1 && year % 1000 != 0 && year % 400 == 0) {
                if (year % 1000 == 0) {
                    if (year % 400 == 0) {
                        day += 29;
                    } else {
                        day += 28;
                    }
                } else {
                    if (year % 4 == 0) {
                        day += 29;
                    } else {
                        day += 28;
                    }
                }
            } else if (month == 8 || month == 3 || month == 5 || month == 10) {
                day += 30;
            } else {
                day += 31;
            }

            month++;

            if (month == 12) {
                year++;
                month = 0;
            }

            if (year == 2001) {
                break;
            }
        }

        log(sundays);
    }

    private void problem20() {
        BigInteger total = new BigInteger("100");

        for (int i = 99; i >= 1; i--) {
            total = total.multiply(new BigInteger(i + ""));
        }

        String totalString = total.toString();
        long sum = 0;
        for (int i = 0; i < totalString.length(); i++) {
            sum += Integer.parseInt(String.valueOf(totalString.charAt(i)));
        }

        log(sum);
    }

    private long getProperDivisorsSum(long n) {
        long sum = 1;

        for (long i = 2; i < n / 2 + 1; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    private void problem21() {
        int amicableSum = 0;
        long a, b;
        for (int i = 1; i < 10000; i++) {
            a = getProperDivisorsSum(i);
            if (a != i) {
                b = getProperDivisorsSum(a);
                if (i == b) {
                    amicableSum += a;
                }
            }
        }

        log(amicableSum);
    }

    private String readFile(String path) {
        try {
            File file = new File(path);
            InputStreamReader is = new InputStreamReader(new FileInputStream(file), "UTF-8");
            StringWriter sw = new StringWriter();

            char[] buffer = new char[4096];
            int read;
            while ((read = is.read(buffer)) != -1) {
                sw.write(buffer, 0, read);
            }

            is.close();
            sw.close();

            return sw.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void problem22() {
        String file = readFile("res/p022_names.txt");

        String[] names = file.split(",");
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].replace("\"", "");
        }

        Collections.sort(Arrays.asList(names));

        long total = 0;
        String name;
        int c, j;
        for (int i = 0; i < names.length; i++) {
            name = names[i];
            c = 0;
            for (j = 0; j < name.length(); j++) {
                c += name.charAt(j) - 'A' + 1;
            }

            total += c * (i + 1);
        }

        log(total);
    }

    private void problem23() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 28123; i++) {
            if (getProperDivisorsSum(i) > i) {
                list.add(i);
            }
        }

        logList(list);

        Set<Integer> sums = new HashSet<>();
        for (int x = 0; x < list.size(); x++) {
            for (int y = 0; y < list.size(); y++) {
                sums.add(list.get(x) + list.get(y));
            }
        }

        long total = 0;
        boolean flag;
        for (int i = 0; i <= 28123; i++) {
            flag = false;
            if (!sums.contains(i)) {
                total += i;
            }
        }

        log("total " + total);
    }

    private void problem27() {
        PrimeFinder primes = new PrimeFinder(100000);
        primes.calculate();

        int tmp = 0;
        int n = 0;

        int a = 0;
        int b = 0;

        int maxPrime = 0;

        final int range = 1000;
        for (a = -range + 1; a < range; a++) {
            for (b = -range + 1; b < range; b++) {
                for (n = 0;; n++) {
                    tmp = (n * n) + (a * n) + b;
                    if (tmp < 0)
                        break;

                    if (primes.get(tmp)) {
                        if (n >= maxPrime) {
                            maxPrime = n;
                            log("Found new max prime a(" + a + ") b(" + b + ") n(" + (n + 1) + ") product(" + (a * b) + ")");
                        }
                        n++;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private void problem28() {
        int sum = 1;
        int total = 1;
        int rad = 2;

        for (int j = 0; j < (1001 / 2); j++) {
            for (int i = 0; i < 4; i++) {
                total += rad;
                sum += total;
            }
            rad += 2;
        }

        log(sum);
    }

    private void problem29() {
        final int aMax = 100;
        final int bMax = 100;

        List<BigInteger> nums = new ArrayList<>();

        BigInteger num;
        int a, b;
        for (a = 2; a <= aMax; a++) {
            for (b = 2; b <= bMax; b++) {
                num = BigInteger.valueOf(a);
                num = num.pow(b);
                if (!nums.contains(num)) {
                    nums.add(num);
                }
            }
        }

        log(nums.size());
    }

    private int intPow(int a, int b) {
        return (int) Math.pow(a, b);
    }

    private long longPow(long a, long b) {
        return (long) Math.pow(a, b);
    }

    private void problem30() {
        final int size = 7;
        final int power = 5;

        final int max = intPow(9, power) * size;

        long totalSum = 0;
        int inc, i;
        long total;
        long[] digits = new long[size];
        for (long j = 2; j < max; j++) {
            for (i = 0; i < size; i++) {
                digits[size - i - 1] = (j / intPow(10, i)) % 10;
            }

            total = 0;
            for (i = 0; i < size; i++) {
                total += longPow(digits[i], power);
            }

            if (total == j) {
                log("Winner! " + j);
                totalSum += j;
            }
        }
        log("Total sum: " + totalSum);
    }

    private void start() {
        problem30();
    }
}
