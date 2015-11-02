package jerome.ktvsingsong.util;

import java.io.InputStreamReader;
import java.util.EnumSet;

import jerome.ktvsingsong.CSVReader;
import jerome.ktvsingsong.SONGClass;
import jerome.ktvsingsong.SONGList;

/**
 * Created by Jerome on 2015/10/25.
 */
public class ParseCSV
{
    public static void parse(InputStreamReader csvInputStream )
    {
        CSVReader csvReader = new CSVReader(csvInputStream);
        try
        {
            String[] name = csvReader.readNext();
            String next[]  = {};
            SONGClass songClass = null;
            for (;;)
            {
                int index = 0;
                next = csvReader.readNext();
                if (next != null)
                {

                    try {
                        songClass = new SONGClass();
//                    songClass.setSerialIndex(Integer.parseInt(next[index++]));
                        songClass.setID(Integer.parseInt(next[index++]));
                        songClass.setSongName(next[index++]);
                        songClass.setSinger(next[index++]);
                        String language = next[index++];
                        if (language.equals("台"))
                            songClass.setLanguage(EnumSet.of(SONGClass.LanguageEnum.TAIWANESE));
                        else if (language.equals("國"))
                            songClass.setLanguage(EnumSet.of(SONGClass.LanguageEnum.CHINESE));
                        else if (language.equals("英"))
                            songClass.setLanguage(EnumSet.of(SONGClass.LanguageEnum.ENGLISH));
                        else if (language.equals("日"))
                            songClass.setLanguage(EnumSet.of(SONGClass.LanguageEnum.JAPANESE));

                        String sex = next[index++];
                        if (sex.equals("男"))
                            songClass.setSex(EnumSet.of(SONGClass.SexEnum.FEMALE));
                        else if (sex.equals("女"))
                            songClass.setSex(EnumSet.of(SONGClass.SexEnum.MALE));
                        else if (sex.equals("合"))
                            songClass.setSex(EnumSet.of(SONGClass.SexEnum.MALE, SONGClass.SexEnum.FEMALE));

                        String MDSNumber = next[index++];
                        if (MDSNumber != null && MDSNumber.length() > 0)
                        {
                            try
                            {
                                songClass.setMDSNumber(MDSNumber);
                            }
                            catch (Exception e)
                            {
                                String message = e.toString();
                                message  = "";
                            }
                        }
                        String GOLD_ENVOICENumber = next[index++];
                        if (GOLD_ENVOICENumber != null && GOLD_ENVOICENumber.length() > 0)
                        {
                            try
                            {
                                songClass.setGoldEnvoiceNumber(GOLD_ENVOICENumber);
                            }
                            catch (Exception e)
                            {
                                String message = e.toString();
                                message  = "";
                            }
                        }

                        String inyuanNumber = next[index++];
                        if (inyuanNumber != null && inyuanNumber.length() > 0) {
                            try
                            {
                                songClass.setInyuanNumber(inyuanNumber);
                            }
                            catch (Exception e)
                            {
                                String message = e.toString();
                                message  = "";
                            }
                        }
                        SONGList.addSong(songClass);
                    }
                    catch (Exception e)
                    {
                        String message = e.toString();
                        message  = "";
                    }
                }
                else
                {
                    break;
                }
            }

        }
        catch (Exception e)
        {
            String message = e.toString();
            message  = "";
        }
    }
}
