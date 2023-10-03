package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "WorldCupMatches")
public class WorldCupMatches {
    @Id
    @Column (name="Year_Cup")
    private  int yearCup;

    @Column (name="Datetime")
    private  String datetime;

    @Column (name="Stage")
    private String  stage;

    @Column (name = "Stadium")
    private  String stadium;

    @Column (name = "City")
    private  String city;

    @Column  (name="Home_Team_Name")
    private String homeTeamName;

    @Column (name="Home_Team_Goals")
    private int homeTeamGoals;

    @Column (name="Away_Team_Goals")
    private int awayTeamGoals;

    @Column (name="Away_Team_Name")
    private String awayTeamName;

    @Column (name="Win_conditions")
    private String winconditions;

    @Column (name="Referee")
    private String  referee;

    @Column (name="MatchID")
    private int  matchID;

    @Column (name="Home_Team_Initials")
    private   String homeTeamInitials;

    @Column(name="Away_Team_Initials")
    private String awayTeamInitials;

    @ManyToOne
    @JoinColumn(name = "Year_Cup", referencedColumnName = "year", insertable = false, updatable = false)
    private WorldCup worldCup;

    public WorldCupMatches() {
    }

    public WorldCupMatches (int yearcup, String datetime, String stage, String stadium, String city, String homeTeamName, int awayTeamGoals, String winconditions, String referee, int matchID, String homeTeamInitials, String awayTeamInitials ) {
        this.yearCup = yearcup;
        this.datetime = datetime;
        this.stage = stage;
        this.stadium = stadium;
        this.city = city;
        this.homeTeamName = homeTeamName;
        this.awayTeamGoals = awayTeamGoals;
        this.winconditions = winconditions;
        this.referee = referee;
        this.matchID = matchID;
        this.homeTeamInitials = homeTeamInitials;
        this.awayTeamInitials = awayTeamInitials;
    }

    public int getYearCup() {
        return yearCup;
    }

    public void setYearCup(int yearCup) {
        this.yearCup = yearCup;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public String getWinconditions() {
        return winconditions;
    }

    public void setWinconditions(String winconditions) {
        this.winconditions = winconditions;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    public String getHomeTeamInitials() {
        return homeTeamInitials;
    }

    public void setHomeTeamInitials(String homeTeamInitials) {
        this.homeTeamInitials = homeTeamInitials;
    }

    public String getAwayTeamInitials() {
        return awayTeamInitials;
    }

    public void setAwayTeamInitials(String awayTeamInitials) {
        this.awayTeamInitials = awayTeamInitials;
    }
}
