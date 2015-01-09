package etc;

public class StringTest 
{
    public interface Repeatable {
        String iteration(long loopId);
    }

    public static long repeat(int times, Repeatable repeatable) {
        long initial = System.currentTimeMillis();
        for (long c = 1; c <= times; c++)
            repeatable.iteration(c);
        long elapsed = System.currentTimeMillis() - initial;
        return elapsed;
    }

    private static Repeatable stringBufferTest = new Repeatable() 
    {
        public String iteration(long loopId) {
         String alias = "a";
         StringBuffer query = new StringBuffer(300);
         query.append("SELECT a.userName, a.registerDate, sum(a.duration), a.id FROM ");
            query.append(StringTest.class.getName())
            .append(" as ").append(alias);
            query.append(" ORDER BY ")
            .append(alias).append(".registerDate desc ");
            return query.toString();
        }
    };
    private static Repeatable stringConcatenationTest = new Repeatable() 
    {
        public String iteration(long loopId) {
        	String alias = "a";
            String query =
                "SELECT " +
                    "a.userName, " +
                    "a.registerDate, " +
                    "sum(a.duration), " +
                    "a.id " +
                "FROM " +
                 StringTest.class.getName() +
                    " as " + alias + "ORDER BY " +
                    alias + ".registerDate desc";
            return query;
        }
    };
    private static Repeatable stringBuilderTest = new Repeatable() 
    {
    	public String iteration(long loopId) {
            String alias = "a";
            StringBuilder query = new StringBuilder(300);
            query.append("SELECT a.userName, a.registerDate, sum(a.duration), a.id FROM ");
               query.append(StringTest.class.getName())
               .append(" as ").append(alias);
               query.append(" ORDER BY ")
               .append(alias).append(".registerDate desc ");
               return query.toString();
           }
    };

    public static void main(String[] args) {
        int times = 1000000;
        long stringBuffElapsed, stringConcatElapsed, stringBuilderElapsed;
        
        for (int loopCount = 1; loopCount <= 5; loopCount++) 
        {
            stringBuffElapsed = repeat(times, stringBufferTest);
            stringConcatElapsed = repeat(times, stringConcatenationTest);
            stringBuilderElapsed = repeat(times, stringBuilderTest);
            System.out.println("반복 횟수 " + loopCount);
            System.out.println("StringBuffer 처리 시간 : " + stringBuffElapsed);
            System.out.println("StringConcatenation 처리 시간 : " + stringConcatElapsed);
            System.out.println("StringBuilder 처리 시간 : " + stringBuilderElapsed + "\n");
        }
    }
} 
