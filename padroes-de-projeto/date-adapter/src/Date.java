public abstract class Date {

    protected int day;
    protected int month;
    protected int year;

    private int[] months30days = {4, 6, 9, 11};

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) throws IllegalArgumentException {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("invalid date");
        }
        this.day = day;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) throws IllegalArgumentException {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("invalid date");
        }
        if (Operand.in(month, this.months30days) && this.getDay() > 30) {
            throw new IllegalArgumentException("invalid date");
        }
        if (month == 2 && this.getDay() > 29) {
            throw new IllegalArgumentException("invalid date");
        }
        if (!isLeapYear(this.getYear()) && this.getDay() > 28) {
            throw new IllegalArgumentException("invalid date");
        }
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) throws IllegalArgumentException{
        if (year < 1) {
            throw new IllegalArgumentException("invalid date");
        }
        this.year = year;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public String toString() {
        return this.getDay() + "/" + this.getMonth() + "/" + this.getYear();
    }
}
