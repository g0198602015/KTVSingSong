package jerome.ktvsingsong;

import java.io.Serializable;
import java.util.EnumSet;

/**
 * Created by Jerome on 2015/10/25.
 */
public class SONGClass implements Serializable
{
    public enum ManufactureEnum
    {
        NONE,
        MDS, // 弘音
        GOLD_ENVOICE, //金嗓
        INYUAN; //音圓
    }

    public enum LanguageEnum
    {
        NONE,
        CHINESE,
        TAIWANESE,
        ENGLISH,
        JAPANESE;
    }
    public enum SexEnum
    {
        NONE,
        FEMALE,
        MALE;
    }
    public enum WordCountEnum
    {
        NONE,
        ONE2FOUR,
        FIVE2EIGHT,
        NINEUP
    }

    private int mSongMaxLength = 0;
    private int mSongMinLength = 0;
    private int mSingerMaxLength = 0;
    private int mSingerMinLength = 0;
    private int mSongLength = 0;
    private int mSerialIndex = 0;
    private int mID = 0;
    private int mSingerLength = 0;
    private String mSongName = "";
    private String mSinger = "";
    private EnumSet<LanguageEnum> mLanguage = EnumSet.of(LanguageEnum.NONE);
    private EnumSet<SexEnum> mSex = EnumSet.of(SexEnum.FEMALE, SexEnum.MALE);
    private EnumSet<WordCountEnum> mWordCountEnum = EnumSet.of(WordCountEnum.NONE);
    private ManufactureEnum mManufacture = ManufactureEnum.NONE;
    private String mMDSNumber = "";
    private String mGOLD_ENVOICENumber = "";
    private String mINYUANNumber = "";
    public int getSongMaxLength() {
        return mSongMaxLength;
    }

    public void setSongMaxLength(int SongMaxLength) {
        this.mSongMaxLength = SongMaxLength;
    }

    public int getSongMinLength() {
        return mSongMinLength;
    }

    public void setSongMinLength(int SongMinLength) {
        this.mSongMinLength = SongMinLength;
    }

    public int getSingerMaxLength() {
        return mSingerMaxLength;
    }

    public void setSingerMaxLength(int SingerMaxLength) {
        this.mSingerMaxLength = SingerMaxLength;
    }

    public int getSingerMinLength() {
        return mSingerMinLength;
    }

    public void setSingerMinLength(int SingerMinLength) {
        this.mSingerMinLength = SingerMinLength;
    }
    public void setSongWordCountLimit(EnumSet<WordCountEnum> wordCountEnum)
    {
        mWordCountEnum = wordCountEnum;
    }
    public EnumSet<WordCountEnum> getWordCountEnum()
    {
        return mWordCountEnum;
    }
    public String getMDSNumber() {
        return mMDSNumber;
    }

    public void setMDSNumber(String MDSNumber) {
        this.mMDSNumber = MDSNumber;
    }

    public String getGoldEnvoiceNumber() {
        return mGOLD_ENVOICENumber;
    }

    public void setGoldEnvoiceNumber(String GOLD_ENVOICENumber) {
        this.mGOLD_ENVOICENumber = GOLD_ENVOICENumber;
    }

    public String getInyuanNumber() {
        return mINYUANNumber;
    }

    public void setInyuanNumber(String INYUANNumber) {
        this.mINYUANNumber = INYUANNumber;
    }
    public int getSerialIndex() {
        return mSerialIndex;
    }

    public void setSerialIndex(int SerialIndex) {
        this.mSerialIndex = SerialIndex;
    }

    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        this.mID = ID;
    }

    public String getSongName() {
        return mSongName;
    }

    public void setSongName(String SongName) {
        this.mSongName = SongName;
        mSongLength = this.mSongName.length();
    }

    public String getSinger() {
        return mSinger;
    }

    public void setSinger(String Singer) {
        this.mSinger = Singer;
        mSingerLength =  this.mSinger.length();
    }

    public EnumSet<LanguageEnum> getLanguage() {
        return mLanguage;
    }

    public void setLanguage(EnumSet<LanguageEnum> Language) {
        this.mLanguage = Language;
    }

    public EnumSet<SexEnum> getSex() {
        return mSex;
    }

    public void setSex(EnumSet<SexEnum> Sex) {
        this.mSex = Sex;
    }
    public ManufactureEnum getManufacture() {
        return mManufacture;
    }

    public void setManufacture(ManufactureEnum Manufacture) {
        this.mManufacture = Manufacture;
    }

    public int getSongLength()
    {
        return mSongLength;
    }
    public int getSingerLength()
    {
        return mSingerLength;
    }

}
