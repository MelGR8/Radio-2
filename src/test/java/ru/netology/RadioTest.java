package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    @Test
    public void shouldSetNextStation() {
        Radio play = new Radio();
        play.next();
        int expected = 1;
        int actual = play.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test public void shouldSetNextStationWhenMax() {
        Radio play = new Radio();
        play.setCurrentRadioStationNumber(9);
        play.next();
        int expected = 0;
        int actual = play.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetNextStationWhenMid() {
        Radio play = new Radio();
        play.setCurrentRadioStationNumber(5);
        play.next();
        int expected = 6;
        int actual = play.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetNewCurrentStationWhenOutOfRangeNegative() {
        Radio play = new Radio();
        play.setCurrentRadioStationNumber(-1);
        int expected = 0;
        int actual = play.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetNewCurrentStationWhenOutOfRangePositive() {
        Radio play = new Radio();
        play.setCurrentRadioStationNumber(10);
        int expected = 0;
        int actual = play.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetNewCurrentStationWhenInPossibleRange() {
        Radio play = new Radio();
        play.setCurrentRadioStationNumber(7);
        int expected = 7;
        int actual = play.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPrevStation() {
        Radio play = new Radio();
        play.prev();
        int expected = 9;
        int actual = play.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPrevStationMid() {
        Radio play = new Radio();
        play.setCurrentRadioStationNumber(6);
        play.prev();
        int expected = 5;
        int actual = play.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetVolumeLevelWhenOutOfRangeNegative() {
        Radio sound = new Radio();
        sound.setVolumeLevel(-1);
        int expected = 0;
        int actual = sound.getVolumeLevel();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetVolumeLevelWhenOutOfRangePositive() {
        Radio sound = new Radio();
        sound.setVolumeLevel(101);
        int expected = 0;
        int actual = sound.getVolumeLevel();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetVolumeLevelWhenInPossibleRange() {
        Radio sound = new Radio();
        sound.setVolumeLevel(40);
        int expected = 40;
        int actual = sound.getVolumeLevel();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddVolume() {
        Radio sound = new Radio();
        sound.plusVolume();
        int expected = 1;
        int actual = sound.getVolumeLevel();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddVolumeFromMid() {
        Radio sound = new Radio();
        sound.setVolumeLevel(69);
        sound.plusVolume();
        int expected = 70;
        int actual = sound.getVolumeLevel();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotAddVolumeFromMax() {
        Radio sound = new Radio();
        sound.setVolumeLevel(100);
        sound.plusVolume();
        int expected = 100;
        int actual = sound.getVolumeLevel();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotDelVolumeFromMin() {
        Radio sound = new Radio();
        sound.minusVolume();
        int expected = 0;
        int actual = sound.getVolumeLevel();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDelVolumeFromMid() {
        Radio sound = new Radio();
        sound.setVolumeLevel(50);
        sound.minusVolume();
        int expected = 49;
        int actual = sound.getVolumeLevel();
        Assertions.assertEquals(expected, actual);
    }
}