package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "WorldCups")
public class WorldCup {
    @Id
    private  int year;
    @Column(name = "Country")
    private String country;
    @Column(name = "Winner")
    private String winner;
    @Column(name = "RunnersUp")
    private String runnersUp;
    @Column(name = "Third")
    private String third;
    @Column(name = "Fourth")
    private String fourth;
    @Column(name = "GoalsScored")
    private int goalsScored;
    @Column(name = "QualifiedTeams")
    private int qualifiedTeams;
    @Column(name = "MatchesPlayed")
    private int matchesPlayed;
    @Column(name = "Attendance")
    private String attendance;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(name="WorldCupMatches",
//    joinColumns = { @JoinColumn(name="Year_Cup", referencedColumnName = "Year") })
//    private WorldCupMatches finalMatch;

    @OneToMany(mappedBy = "worldCup")
    private List<WorldCupMatches> matches;

    public WorldCup() {
    }

    public WorldCup(int year, String country, String winner, String runnersUp, String third, String fourth, int goalsScored, int qualifiedTeams, int matchesPlayed, String attendance) {
        this.year = year;
        this.country = country;
        this.winner = winner;
        this.runnersUp = runnersUp;
        this.third = third;
        this.fourth = fourth;
        this.goalsScored = goalsScored;
        this.qualifiedTeams = qualifiedTeams;
        this.matchesPlayed = matchesPlayed;
        this.attendance = attendance;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getRunnersUp() {
        return runnersUp;
    }

    public void setRunnersUp(String runnersUp) {
        this.runnersUp = runnersUp;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getFourth() {
        return fourth;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getQualifiedTeams() {
        return qualifiedTeams;
    }

    public void setQualifiedTeams(int qualifiedTeams) {
        this.qualifiedTeams = qualifiedTeams;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public List<WorldCupMatches> getMatches() {
        return matches;
    }

    public void setMatches(List<WorldCupMatches> matches) {
        this.matches = matches;
    }

    @Override
    public String toString() {
        return "Copa de " + year + '\n' +
                "   País Sede: " + country + '\n' +
                "   Campeão: " + winner + '\n' +
                "   Vice-Campeão: " + runnersUp  + '\n';
    }
}
