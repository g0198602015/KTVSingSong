package jerome.ktvsingsong;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by Jerome on 2015/10/25.
 */
public class SONGList
{
    private static List<SONGClass> mSongClassList  = new ArrayList<SONGClass>();

    public static void addSong(SONGClass song)
    {
        mSongClassList.add(song);
    }
    public static List<SONGClass> searchSong(SONGClass searchSongCondition)
    {
        List<SONGClass> result  = new ArrayList<SONGClass>();
        long size = mSongClassList.size();
        for (int index = 0 ; index < size ; index++)
        {
            SONGClass tempSongClass = mSongClassList.get(index);
            EnumSet<SONGClass.LanguageEnum> templanguage = tempSongClass.getLanguage();
            EnumSet<SONGClass.LanguageEnum> searchLanguage = searchSongCondition.getLanguage();
            if (!searchLanguage.containsAll(templanguage))
                continue;

            EnumSet<SONGClass.SexEnum> tempSex = tempSongClass.getSex();
            EnumSet<SONGClass.SexEnum> searchSex = searchSongCondition.getSex();
            if (!searchSex.containsAll(tempSex))
                continue;
            boolean songFlag = false;
            if (searchSongCondition.getWordCountEnum().contains(SONGClass.WordCountEnum.ONE2FOUR))
            {
                if (tempSongClass.getSongLength() >= 1 && tempSongClass.getSongLength() <= 4)
                    songFlag = true;
            }
            if (searchSongCondition.getWordCountEnum().contains(SONGClass.WordCountEnum.FIVE2EIGHT))
            {
                if (tempSongClass.getSongLength() >= 5 && tempSongClass.getSongLength() <= 8)
                    songFlag = true;
            }
            if (searchSongCondition.getWordCountEnum().contains(SONGClass.WordCountEnum.NINEUP))
            {
                if (tempSongClass.getSongLength() >= 9)
                    songFlag = true;
            }

            if (!songFlag)
                continue;

//            if (tempSongClass.getSongLength() < searchSongCondition.getSongMinLength() ||
//                tempSongClass.getSongLength() > searchSongCondition.getSongMaxLength())
//                continue;
//
//            if (tempSongClass.getSingerLength() < searchSongCondition.getSingerMinLength() ||
//                tempSongClass.getSingerLength() > searchSongCondition.getSingerMaxLength())
//                continue;
            String searchSongName = searchSongCondition.getSongName();
            String tempSongName = tempSongClass.getSongName();
            if (searchSongName != null && searchSongName.length() > 0)
            {
                if (!tempSongName.toLowerCase().contains(searchSongName.toLowerCase()))
                    continue;
            }
            result.add(tempSongClass);
        }
        return result;
    }


}
