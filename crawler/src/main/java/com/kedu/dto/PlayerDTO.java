package com.kedu.dto;

public class PlayerDTO {
	

    private int seq;
    private String playerName;
    private String teamName;

    private int ranking;
    private double battingAvg;

    private int games;
    private int plateAppearances;
    private int atBats;

    private int runs;
    private int hits;
    private int doubles;
    private int triples;
    private int homeRuns;
    private int totalBases;
    private int rbi;

    private int stolenBases;
    private int caughtStealing;

    private int walks;
    private int hitByPitch;
    private int strikeouts;
    private int groundedIntoDoublePlay;

    private int sacrificeBunts;
    private int sacrificeFlies;

    private double sluggingPct;
    private double onBasePct;
    private double ops;

    public PlayerDTO() {
    }

    public PlayerDTO(int seq, String playerName, String teamName, int ranking, double battingAvg,
            int games, int plateAppearances, int atBats, int runs, int hits,
            int doubles, int triples, int homeRuns, int totalBases, int rbi,
            int stolenBases, int caughtStealing, int walks, int hitByPitch,
            int strikeouts, int groundedIntoDoublePlay, int sacrificeBunts,
            int sacrificeFlies, double sluggingPct, double onBasePct, double ops) {

        this.seq = seq;
        this.playerName = playerName;
        this.teamName = teamName;
        this.ranking = ranking;
        this.battingAvg = battingAvg;
        this.games = games;
        this.plateAppearances = plateAppearances;
        this.atBats = atBats;
        this.runs = runs;
        this.hits = hits;
        this.doubles = doubles;
        this.triples = triples;
        this.homeRuns = homeRuns;
        this.totalBases = totalBases;
        this.rbi = rbi;
        this.stolenBases = stolenBases;
        this.caughtStealing = caughtStealing;
        this.walks = walks;
        this.hitByPitch = hitByPitch;
        this.strikeouts = strikeouts;
        this.groundedIntoDoublePlay = groundedIntoDoublePlay;
        this.sacrificeBunts = sacrificeBunts;
        this.sacrificeFlies = sacrificeFlies;
        this.sluggingPct = sluggingPct;
        this.onBasePct = onBasePct;
        this.ops = ops;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public double getBattingAvg() {
        return battingAvg;
    }

    public void setBattingAvg(double battingAvg) {
        this.battingAvg = battingAvg;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getPlateAppearances() {
        return plateAppearances;
    }

    public void setPlateAppearances(int plateAppearances) {
        this.plateAppearances = plateAppearances;
    }

    public int getAtBats() {
        return atBats;
    }

    public void setAtBats(int atBats) {
        this.atBats = atBats;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getDoubles() {
        return doubles;
    }

    public void setDoubles(int doubles) {
        this.doubles = doubles;
    }

    public int getTriples() {
        return triples;
    }

    public void setTriples(int triples) {
        this.triples = triples;
    }

    public int getHomeRuns() {
        return homeRuns;
    }

    public void setHomeRuns(int homeRuns) {
        this.homeRuns = homeRuns;
    }

    public int getTotalBases() {
        return totalBases;
    }

    public void setTotalBases(int totalBases) {
        this.totalBases = totalBases;
    }

    public int getRbi() {
        return rbi;
    }

    public void setRbi(int rbi) {
        this.rbi = rbi;
    }

    public int getStolenBases() {
        return stolenBases;
    }

    public void setStolenBases(int stolenBases) {
        this.stolenBases = stolenBases;
    }

    public int getCaughtStealing() {
        return caughtStealing;
    }

    public void setCaughtStealing(int caughtStealing) {
        this.caughtStealing = caughtStealing;
    }

    public int getWalks() {
        return walks;
    }

    public void setWalks(int walks) {
        this.walks = walks;
    }

    public int getHitByPitch() {
        return hitByPitch;
    }

    public void setHitByPitch(int hitByPitch) {
        this.hitByPitch = hitByPitch;
    }

    public int getStrikeouts() {
        return strikeouts;
    }

    public void setStrikeouts(int strikeouts) {
        this.strikeouts = strikeouts;
    }

    public int getGroundedIntoDoublePlay() {
        return groundedIntoDoublePlay;
    }

    public void setGroundedIntoDoublePlay(int groundedIntoDoublePlay) {
        this.groundedIntoDoublePlay = groundedIntoDoublePlay;
    }

    public int getSacrificeBunts() {
        return sacrificeBunts;
    }

    public void setSacrificeBunts(int sacrificeBunts) {
        this.sacrificeBunts = sacrificeBunts;
    }

    public int getSacrificeFlies() {
        return sacrificeFlies;
    }

    public void setSacrificeFlies(int sacrificeFlies) {
        this.sacrificeFlies = sacrificeFlies;
    }

    public double getSluggingPct() {
        return sluggingPct;
    }

    public void setSluggingPct(double sluggingPct) {
        this.sluggingPct = sluggingPct;
    }

    public double getOnBasePct() {
        return onBasePct;
    }

    public void setOnBasePct(double onBasePct) {
        this.onBasePct = onBasePct;
    }

    public double getOps() {
        return ops;
    }

    public void setOps(double ops) {
        this.ops = ops;
    }
}

