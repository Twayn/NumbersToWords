package numbersinwords;

public interface Constants {
	int singularIndex = 0;
	int from2to4Index = 1;
	int from5to9Index = 2;

	String[][] POWER = new String[][]{
			{""            , ""             , ""              },
			{"тысяча "     , "тысячи "      , "тысяч "        },
			{"миллион "    , "миллиона "    , "миллионов "    },
			{"миллиард "   , "миллиарда "   , "миллиардов "   },
			{"триллион "   , "триллиона "   , "триллионов "   },
			{"квадриллион ", "квадриллиона ", "квадриллионов "},
			{"квинтиллион ", "квинтиллиона ", "квинтиллионов "},
			{"секстиллион ", "секстиллиона ", "секстиллионов "},
			{"септиллион " , "септиллиона " , "септиллионов " },
			{"октиллион "  , "октиллиона "  , "октиллионов "  },
	};

	int forOthersIndex = 0;
	int forThousandsIndex = 1;
	int from11to20Index = 2;
	int decadesIndex = 3;
	int hundredsIndex = 4;

	String[][] DIGIT = new String[][] {
			{""       , ""       , "десять "      , ""            , ""          },
			{"один "  , "одна "  , "одиннадцать " , "десять "     , "сто "      },
			{"два "   , "две "   , "двенадцать "  , "двадцать "   , "двести "   },
			{"три "   , "три "   , "тринадцать "  , "тридцать "   , "триста "   },
			{"четыре ", "четыре ", "четырнадцать ", "сорок "      , "четыреста "},
			{"пять "  , "пять "  , "пятнадцать "  , "пятьдесят "  , "пятьсот "  },
			{"шесть " , "шесть " , "шестнадцать " , "шестьдесят " , "шестьсот " },
			{"семь "  , "семь "  , "семнадцать "  , "семьдесят "  , "семьсот "  },
			{"восемь ", "восемь ", "восемнадцать ", "восемьдесят ", "восемьсот "},
			{"девять ", "девять ", "девятнадцать ", "девяносто "  , "девятьсот "}
	};
}