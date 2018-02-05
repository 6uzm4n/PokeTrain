public class Pokemon {

    //Pokemon data
    private int dex;
    private String name;
    private int level;
    private String nature;

    //Pokemon base stats
    private int baseHP;
    private int baseAtk;
    private int baseDef;
    private int baseSpA;
    private int baseSpD;
    private int baseSpe;

    //Pokemon stats
    private int HP;
    private int Atk;
    private int Def;
    private int SpA;
    private int SpD;
    private int Spe;

    //Pokemon IVs
    private int ivHP;
    private int ivAtk;
    private int ivDef;
    private int ivSpA;
    private int ivSpD;
    private int ivSpe;

    //Pokemon EVs
    private int evHP;
    private int evAtk;
    private int evDef;
    private int evSpA;
    private int evSpD;
    private int evSpe;

    /*
     * Class constructor.
     */
    public Pokemon(int pDex, String pName, int pLevel, String pNature, int pBaseHP, int pBaseAtk, int pBaseDef,
                   int pBaseSpA, int pBaseSpD, int pBaseSpe, int pIvHP, int pIvAtk, int pIvDef, int pIvSpA, int pIvSpD,
                   int pIvSpe, int pEvHP, int pEvAtk, int pEvDef, int pEvSpA, int pEvSpD, int pEvSpe){

        this.dex = pDex;
        this.name = pName;
        this.level = pLevel;
        this.nature = pNature;

        this.baseHP = pBaseHP;
        this.baseAtk = pBaseAtk;
        this.baseDef = pBaseDef;
        this.baseSpA = pBaseSpA;
        this.baseSpD = pBaseSpD;
        this.baseSpe = pBaseSpe;

        this.ivHP = pIvHP;
        this.ivAtk = pIvAtk;
        this.ivDef = pIvDef;
        this.ivSpA = pIvSpA;
        this.ivSpD = pIvSpD;
        this.ivSpe = pIvSpe;

        this.evHP = pEvHP;
        this.evAtk = pEvAtk;
        this.evDef = pEvDef;
        this.evSpA = pEvSpA;
        this.evSpD = pEvSpD;
        this.evSpe = pEvSpe;
    }

    /*
     * This method calculates the stats of the Pokemon using all the necessary parameters.
     */
    public void update(){
        this.HP = calculateHP(level, baseHP, ivHP, evHP);
        this.Atk = calculateStat(level, baseAtk, ivAtk, evAtk);
        this.Def = calculateStat(level, baseDef, ivDef, evDef);
        this.SpA = calculateStat(level, baseSpA, ivSpA, evSpA);
        this.SpD = calculateStat(level, baseSpD, ivSpD, evSpD);
        this.Spe = calculateStat(level, baseSpe, ivSpe, evSpe);
    }

    /*
     * This method returns the HP of a Pokemon given the nesessary parameters.
     * It is only valid for calculating the HP.
     */
    private int calculateHP(int pLevel, int pBaseHP, int pIvHP, int pEvHP){
        int HP = ((((2 * pBaseHP) + pIvHP + (pEvHP)) * pLevel) / 100) + pLevel + 10;
        return HP;
    }

    /*
     * This method returns the stat of a Pokemon given the nesessary parameters.
     * It is valid for any stat except HP.
     */
    private int calculateStat(int pLevel, int pBaseStat, int pIv, int pEv){
        int stat = (((((2 * pBaseStat) + pIv + (pEv)) * pLevel) / 100) + 5) * 1; //TODO: Change 1 with nature multiplier
        return stat;
    }

    public void printStats(){
        update();
        System.out.println(HP + " " + Atk + " " + Def + " " + SpA + " " + SpD + " " + Spe);
    }
}
