import java.util.Comparator;

public class PLayer {
    int number;
    String firstname;
    String lastname;
    String name;
    String teamname;
    double goals;
    int gp;
    int gs;
    int minutes;
    int assists;
    int yellowcards;
    int redcards;
    double shots;
    double shotsontarget;
    double shotaccur;
    double conversion;
    int goalcontributions;
    double goalspermin;
    double goalcontpermin;

    PLayer() {
    }

    PLayer (int number, String teamname, String firstname, String lastname, int gp, int gs, int minutes, double goals, int assists, double shots, double shotsontarget, int yellowcards, int redcards) {
        this.firstname = firstname;
        this.lastname = lastname;
        name = firstname + " " + lastname;
        this.teamname = teamname;
        this.gp = gp;
        this.gs = gs;
        this.minutes = minutes;
        this.goals = goals;
        this.assists = assists;
        this.yellowcards = yellowcards;
        this.redcards = redcards;
        this.shots = shots;
        this.shotsontarget = shotsontarget;
        if (shots != 0) {
            this.shotaccur = (shotsontarget / shots) * 100;
            this.conversion = (goals / shots) * 100;
        }
        this.goalcontributions = (int) goals + assists;
        if (minutes != 0) {
            this.goalcontpermin = ((goals+assists)/minutes)*90;
            this.goalspermin = (goals/minutes)*90;
        }

    }
    public String toString() {
        return firstname + " " + lastname + " of " + teamname;
    }
    public static Comparator<PLayer> goalComp = new Comparator<PLayer>() {
        public int compare(PLayer o1, PLayer o2) {
            return Double.compare(o1.goals, o2.goals);
        }
    };
    public static Comparator<PLayer> assistComp = new Comparator<PLayer>() {
        public int compare(PLayer o1, PLayer o2) {
            return o1.assists - o2.assists;
        }
    };
    public static Comparator<PLayer> yellowCards = new Comparator<PLayer>() {
        public int compare(PLayer o1, PLayer o2) {
            return o1.yellowcards - o2.yellowcards;
        }
    };
    public static Comparator<PLayer> redCards = new Comparator<PLayer>() {
        public int compare(PLayer o1, PLayer o2) {
            return o1.redcards - o2.redcards;
        }
    };
        public static Comparator<PLayer> totalCards = new Comparator<PLayer>() {
            public int compare(PLayer o1, PLayer o2) {
                return (o1.yellowcards + o1.redcards) - (o2.yellowcards + o2.redcards);
            }
        };
    public static Comparator<PLayer> shotsComp = new Comparator<PLayer>() {
        public int compare(PLayer o1, PLayer o2) {
            return Double.compare(o1.shots, o2.shots);
        }
    };
    public static Comparator<PLayer> shotstargetcomp = new Comparator<PLayer>() {
        public int compare(PLayer o1, PLayer o2) {
            return Double.compare(o1.shotsontarget, o2.shotsontarget);
        }
    };
    public static Comparator<PLayer> mostAccurate = new Comparator<PLayer>() {
        public int compare(PLayer o1, PLayer o2) {
            return Double.compare(o1.shotaccur, o2.shotaccur);
        }
    };
    public static Comparator<PLayer> conversionrate = new Comparator<PLayer>() {
        public int compare(PLayer o1, PLayer o2) {
            return Double.compare(o1.conversion, o2.conversion);
        }
    };
    public static Comparator<PLayer> contributions = new Comparator<PLayer>() {
        public int compare(PLayer o1, PLayer o2) {
            return Double.compare(o1.goalcontributions, o2.goalcontributions);
        }
    };
    public static Comparator<PLayer> goalsperminute = new Comparator<PLayer>() {
        public int compare(PLayer o1, PLayer o2) {
            return Double.compare(o1.goalspermin, o2.goalspermin);
        }
    };
    public static Comparator<PLayer> goalcontribpermin = new Comparator<PLayer>() {
        public int compare(PLayer o1, PLayer o2) {
            return Double.compare(o1.goalcontpermin, o2.goalcontpermin);
        }
    };
    public static Comparator<PLayer> gamesPlayed = new Comparator<PLayer>() {
        public int compare(PLayer o1, PLayer o2) {
            return Double.compare(o1.gp, o2.gp);
        }
    };



}
