public class Main {
    public static void main(String[] args)
    {
        String text = "Теперь моя моя пора: я не люблю весны;\n" +
                "Скучна мне оттепель; вонь, грязь — весной я болен;\n" +
                "Кровь бродит; чувства, ум тоскою стеснены.\n" +
                "Суровою зимой я более доволен,\n" +
                "Люблю её снега; в присутствии луны\n" +
                "Как лёгкий бег саней с подругой быстр и волен,\n" +
                "Когда под соболем, согрета и свежа,\n" +
                "Она вам руку жмёт, пылая и дрожа!";
        String[] keys = text.split(" ");
        String[] uniqueKeys;
        int count = 0;
        System.out.println(text);
        uniqueKeys = getUniqueKeys(keys);

        for(String key: uniqueKeys)
        {
            if(null == key)
            {
                break;
            }
            for(String s : keys)
            {
                if(key.equals(s))
                {
                    count++;
                }
            }
            System.out.println("Count of ["+key+"] is : "+count);
            count=0;
        }
    }

    private static String[] getUniqueKeys(String[] keys)
    {
        String[] uniqueKeys = new String[keys.length];

        uniqueKeys[0] = keys[0];
        int uniqueKeyIndex = 1;
        boolean keyAlreadyExists = false;

        for(int i=1; i<keys.length ; i++)
        {
            for(int j=0; j<=uniqueKeyIndex; j++)
            {
                if(keys[i].equals(uniqueKeys[j]))
                {
                    keyAlreadyExists = true;
                }
            }

            if(!keyAlreadyExists)
            {
                uniqueKeys[uniqueKeyIndex] = keys[i];
                uniqueKeyIndex++;
            }
            keyAlreadyExists = false;
        }
        return uniqueKeys;
    }


}
