package ClassPractice;

public class Tester {
    //we can set the pointer outside....
    //הגדרת מצביע למערך של מספרים ייחודיים
    public static int pointer;
    //הגדרת גודל המערכים הרצוי
    public static final int SIZE = 10;
    //יצירת מערך בערכים ובגודל שנקבע
    public static int[] distinct= fillMinus(SIZE,-1);

    public static void main(String[] args) {
        //יצירת מערך רנדומלי ראשון
        int[] arr1 = getArray(SIZE);
        //יצירת מערך רנדומלי שני
        int[] arr2 = getArray(SIZE);
        //הדפסת מערך ראשון
        printArray(arr1);
        //הדפסת מערך שני
        printArray(arr2);
        //הדפסת המספר הגדול ביותר
        System.out.println("Biggest number:" + getBigNumber(arr1, 3));
        //איפוס המצביע של מערך ייחודי
        pointer = 0;
        //קבלת ערכים ייחודים שקיימים במערך הראשון ולא קיימים במערך השני
        getDistinct(arr1, arr2);
        //קבלת ערכים ייוחדים שקיימים במערך השני ולא קיימים במערך הראשון
        getDistinct(arr2,arr1);
        //הדפסת מערך הייחודיים
        printArray(distinct);
        //הדפסת המספר המתקבל ממערך הייחודיים
        printDistinct(distinct);
    }

    // פונקציה המקבלת אורך SIZE ומחזירה מערך חדש מאותחל בנתונים
    public static int[] getArray(int size) {
        //הגדרת מערך לפי גודל שהגדרנו
        int[] newArray = new int[size];
        //ביצוע איטרציה על כל המערך
        for (int index = 0; index < newArray.length; index++) {
            //הכנסת מספר רנדומלי למערך בערכים 0-9
            newArray[index] = (int) (Math.random() * 10);
        }
        //החזרת המערך החדש
        return newArray;
    }

    //פונקציה להדפסת מערך כלשהוא
    public static void printArray(int[] array) {
        //איטרציה על כל אברי המערך
        for (int index = 0; index < array.length; index++) {
            //הדפסת המערך עם רווח
            System.out.print(array[index] + " ");
        }
        //ירידת שורה
        System.out.println();
    }

    //פונקציה לקבלת המספר הגדול ביותר במערך מסויים
    public static int getBigNumber(int[] arr, int size) {
        //איתחול המספר למספר הגדול ביותר
        int bigNumber = 0;
        //הגדרת מספר חדש לקליטה
        int newNumber;
        //מעבר על המערך פחות גודל מספר האיברים הנדרש
        //בצורה כזאת אנו נמנעים מתקלה של
        //indexOutOfBoundsException
        for (int counter = 0; counter < arr.length - size; counter++) {
            //איתחול המספר לקליטה
            newNumber = 0;
            //מעבר על האיברים בגודל שביקשנו
            for (int index = counter; index < counter + size; index++) {
                //הכפלה בעשר והוספת המספר מהאיבר
                newNumber = newNumber * 10 + arr[index];
            }
            //בדיקה אם המספר שקיבלנו גדול מהמספר שאנחנו מחזיקים
            if (newNumber > bigNumber) {
                //עידכון המספר שאנו מחזיקים למספר הגדול שמצאנו
                bigNumber = newNumber;
            }
        }
        //החזרת המספר
        return bigNumber;
    }

    //פונקציה למילוי בערכים מערך מסויים עפ״י ערך מסויים
    public static int[] fillMinus(int size,int value) {
        //יצירת מערך בגודל המבוקש
        int[] newArr = new int[size];
        //איטרציה על כל אברי המערך
        for (int index = 0; index < newArr.length; index++) {
            //עידכון האיבר במערך בערך שאנו מבקשים
            newArr[index] = value;
        }
        //החזרת המערך
        return newArr;
    }

    //פונקציה לקבל ערכים ייחודים בין שני מערכים
    public static int[] getDistinct(int[] arr1, int[] arr2) {
        //איתחול של משתנה בוליאני, אנו יוצאים מנקודת הנחה
        //שלא מצאנו מספר שמופיע
        boolean isFound = false;
        //איטרציה על המערך הראשון
        for (int index1 = 0; index1 < arr1.length; index1++) {
            //איתחול המשתנה הבוליאני
            isFound = false;
            for (int index2 = 0; index2 < arr2.length; index2++) {
                //בדיקה אם המספר במערך הראשון מופיע גם במערך השני
                if (arr1[index1] == arr2[index2]) {
                    //במידה ומצאנו, אנו נעדכן את המשתנה הבוליאני
                    isFound = true;
                    //אין טעם לבדוק את שאר האיברים במערך, לכן נצא מהלולאה
                    break;
                }
            }
            //במידה והמשתנה הבוליאני מצביע שלא מצאנו איבר דומה
            if (!isExist(arr1[index1]) && !isFound) {
                //נוסיף את המספר החדש למערך של מספרים ייחודיים
                distinct[pointer] = arr1[index1];
                //נעדכן את המצביע שיצביע על המקום הפנוי הבא
                pointer++;
            }
        }
        //החזרת מערך של ייחודיים
        return distinct;
    }

    //פונקציה לבדיקת המצאות של ערך מסויים
    public static boolean isExist(int num) {
        //איטרציה על מערך הייחודיים לאיתור מספר קיים
        for (int index = 0; index < distinct.length; index++) {
            //במידה ומצאנו את המספר, נחזיר ערך חיובי ובכך גם נצא מהפונקציה
            if (distinct[index] == num) {
                return true;
            }
        }
        //אם הגענו עד לכאן כנראה שלא מצאנו, לכן נחזיר ערך שלילי
        //המציין כי המספר איננו קיים במערך
        return false;
    }

    //הדפסת מספר מתוך מערכים ייחודיים
    public static void printDistinct(int[] distinct) {
        //איתחול המספר החדש
        int newNumber = 0;
        //מעבר על המערך מהסוף להתחלה, על מנת להקל על החישוב
        for (int index = distinct.length - 1; index >= 0; index--) {
            //במידה והערך שלילי, כלומר לא הוכנס מספר אליו
            if (distinct[index] != -1) {
                //נעדכן את המערך ע״י הכפלה ב10 והוספת הערך החדש
                newNumber = newNumber * 10 + distinct[index];
            }
        }
        //הדפסת הערך החדש
        System.out.println(newNumber);
    }
}