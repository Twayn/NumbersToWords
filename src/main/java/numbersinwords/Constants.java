package numbersinwords;

import static numbersinwords.INumberInWords.ACCUSATIVE;
import static numbersinwords.INumberInWords.DATIVE;
import static numbersinwords.INumberInWords.GENITIVE;
import static numbersinwords.INumberInWords.INSTRUMENTAL;
import static numbersinwords.INumberInWords.NOMINATIVE;
import static numbersinwords.INumberInWords.PREPOSITIONAL;

import java.util.List;
import java.util.Map;

public interface Constants {
	int singularIndex = 0;
	int from2to4Index = 1;
	int othersIndex = 2;

	int forOthersIndex = 0;
	int forThousandsIndex = 1;
	int from11to20Index = 2;
	int decadesIndex = 3;
	int hundredsIndex = 4;

	Map<String, String> FOR_ZERO = Map.of(
		NOMINATIVE, "ноль",
		GENITIVE, "ноля",
		DATIVE, "нолю",
		ACCUSATIVE, "ноль",
		INSTRUMENTAL, "нолем",
		PREPOSITIONAL, "о ноле"
	);

	Map<String, String> F_NOMINATIVE = Map.of(
		"один", "одна", "два", "две"
	);

	Map<String, String> F_GENITIVE = Map.of(
		"одного", "одной", "двух", "двух"
	);

	Map<String, String> F_DATIVE = Map.of(
		"одному", "одной", "двум", "двум"
	);

	Map<String, String> F_ACCUSATIVE = Map.of(
		"один", "одну", "два", "две"
	);

	Map<String, String> F_INSTRUMENTAL = Map.of(
		"одним", "одной", "двумя", "двумя"
	);

	Map<String, String> F_PREPOSITIONAL = Map.of(
		"одном", "одной", "двух", "двух"
	);

	Map<String, String> N_NOMINATIVE_AND_ACCUSATIVE = Map.of(
		"один", "одно", "два", "два"
	);

	List<String> IS_NEED_TO_DECLINE = List.of("один", "два", "одного", "одному", "одним", "одном");

	String[][] POWER_NOMINATIVE = new String[][]{
			{""            , ""             , ""              },
			{"тысяча "     , "тысячи "      , "тысяч "        },
			{"миллион "    , "миллиона "    , "миллионов "    },
			{"миллиард "   , "миллиарда "   , "миллиардов "   },
			{"триллион "   , "триллиона "   , "триллионов "   },
	};

	String[][] DIGIT_NOMINATIVE = new String[][] {
			{""       , ""       , "десять "      , ""            , ""          },
			{"один "  , "одна "  , "одиннадцать " , "десять "     , "сто "      },
			{"два "   , "две "   , "двенадцать "  , "двадцать "   , "двести "   },
			{"три "   , "три "   , "тринадцать "  , "тридцать "   , "триста "   },
			{"четыре ", "четыре ", "четырнадцать ", "сорок "      , "четыреста "},
			{"пять "  , "пять "  , "пятнадцать "  , "пятьдесят "  , "пятьсот "  },
			{"шесть " , "шесть " , "шестнадцать " , "шестьдесят " , "шестьсот " },
			{"семь "  , "семь "  , "семнадцать "  , "семьдесят "  , "семьсот "  },
			{"восемь ", "восемь ", "восемнадцать ", "восемьдесят ", "восемьсот "},
			{"девять ", "девять ", "девятнадцать ", "девяносто "  , "девятьсот "},
	};

	String[][] POWER_GENITIVE = new String[][]{
			{""             , ""              , ""              },
			{"тысячи "      , "тысяч "        , "тысяч "        },
			{"миллиона "    , "миллионов "    , "миллионов "    },
			{"миллиарда "   , "миллиардов "   , "миллиардов "   },
			{"триллиона "   , "триллионов "   , "триллионов "   },
	};

	String[][] DIGIT_GENITIVE = new String[][] {
			{""         , ""         , "десяти "       , ""              , ""            },
			{"одного "  , "одной "   , "одиннадцати "  , "десяти "       , "ста "        },
			{"двух "    , "двух "    , "двенадцати "   , "двадцати "     , "двухсот "    },
			{"трех "    , "трех "    , "тринадцати "   , "тридцати "     , "трехсот "    },
			{"четырех " , "четырех " , "четырнадцати " , "сорока "       , "четырехсот " },
			{"пяти "    , "пяти "    , "пятнадцати "   , "пятидесяти "   , "пятисот "    },
			{"шести "   , "шести "   , "шестнадцати "  , "шестидесяти "  , "шестисот "   },
			{"семи "    , "семи "    , "семнадцати "   , "семидесяти "   , "семисот "    },
			{"восьми "  , "восьми "  , "восемнадцати " , "восьмидесяти " , "восьмисот "  },
			{"девяти "  , "девяти "  , "девятнадцати " , "девяноста "    , "девятисот "  },
	};

	String[][] POWER_DATIVE = new String[][]{
			{""           , ""            , ""            },
			{"тысяче "    , "тысячам "    , "тысячам "    },
			{"миллиону "  , "миллионам "  , "миллионам "  },
			{"миллиарду " , "миллиардам " , "миллиардам " },
			{"триллиону " , "триллионам " , "триллионам " },
	};

	String[][] DIGIT_DATIVE = new String[][] {
			{""        , ""        , "десяти "      , ""             , ""             },
			{"одному " , "одной "  , "одиннадцати " , "десяти "      , "ста "         },
			{"двум "   , "двум "   , "двенадцати "  , "двадцати "    , "двухстам "    },
			{"трем "   , "трем "   , "тринадцати "  , "тридцати "    , "тремстам "    },
			{"четырем ", "четырем ", "четырнадцати ", "сорока "      , "четыремстам " },
			{"пяти "   , "пяти "   , "пятнадцати "  , "пятидесяти "  , "пятистам "    },
			{"шести "  , "шести "  , "шестнадцати " , "шестидесяти " , "шестистам "   },
			{"семи "   , "семи "   , "семнадцати "  , "семидесяти "  , "семистам "    },
			{"восьми " , "восьми " , "восемнадцати ", "восьмидесяти ", "восьмистам "  },
			{"девяти " , "девяти " , "девятнадцати ", "девяноста "   , "девятистам "  },
	};

	String[][] POWER_ACCUSATIVE = new String[][]{
			{""          , ""           , ""            },
			{"тысячу "   , "тысячи "    , "тысяч "      },
			{"миллион "  , "миллиона "  , "миллионов "  },
			{"миллиард " , "миллиарда " , "миллиардов " },
			{"триллион " , "триллиона " , "триллионов " },
	};

	String[][] DIGIT_ACCUSATIVE = new String[][] {
			{""         , ""        , "десять "      , ""             , ""           },
			{"один "    , "одну "   , "одиннадцать " , "десять "      , "сто "       },
			{"два "     , "две "    , "двенадцать "  , "двадцать "    , "двести "    },
			{"три "     , "три "    , "тринадцать "  , "тридцать "    , "триста "    },
			{"четыре "  , "четыре " , "четырнадцать ", "сорок "       , "четыреста " },
			{"пять "    , "пять "   , "пятнадцать "  , "пятьдесят "   , "пятьсот "   },
			{"шесть "   , "шесть "  , "шестнадцать " , "шестьдесят "  , "шестьсот "  },
			{"семь "    , "семь "   , "семнадцать "  , "семьдесят "   , "семьсот "   },
			{"восемь "  , "восемь " , "восемнадцать ", "восемьдесят " , "восемьсот " },
			{"девять "  , "девять " , "девятнадцать ", "девяносто "   , "девятьсот " },
	};

	String[][] POWER_INSTRUMENTAL = new String[][]{
			{""            , ""             , ""             },
			{"тысячей "    , "тысячами "    , "тысячами "    },
			{"миллионом "  , "миллионами "  , "миллионами "  },
			{"миллиардом " , "миллиардами " , "миллиардами " },
			{"триллионом " , "триллионами " , "триллионами " },
	};

	String[][] DIGIT_INSTRUMENTAL = new String[][] {
			{""          , ""          , "десятью "       , ""                , ""               },
			{"одним "    , "одной "    , "одиннадцатью "  , "десятью "        , "ста "           },
			{"двумя "    , "двумя "    , "двенадцатью "   , "двадцатью "      , "двумястами "    },
			{"тремя "    , "тремя "    , "тринадцатью "   , "тридцатью "      , "тремястами "    },
			{"четырьмя " , "четырьмя " , "четырнадцатью " , "сорока "         , "четырьмястами " },
			{"пятью "    , "пятью "    , "пятнадцатью "   , "пятьюдесятью "   , "пятьюстами "    },
			{"шестью "   , "шестью "   , "шестнадцатью "  , "шестьюдесятью "  , "шестьюстами "   },
			{"семью "    , "семью "    , "семнадцатью "   , "семьюдесятью "   , "семьюстами "    },
			{"восьмью "  , "восемью "  , "восемнадцатью " , "восьмьюдесятью " , "восемьюстами "  },
			{"девятью "  , "девятью "  , "девятнадцатью " , "девяноста "      , "девятьюстами "  },
	};

	String[][] POWER_PREPOSITIONAL = new String[][]{
			{""           , ""            , ""            },
			{"тысяче "    , "тысячах "    , "тысячах "    },
			{"миллионе "  , "миллионах "  , "миллионах "  },
			{"миллиарде " , "миллиардах " , "миллиардах " },
			{"триллионе " , "триллионах " , "триллионах " },
	};

	String[][] DIGIT_PREPOSITIONAL = new String[][] {
			{""        , ""        , "десяти "      , ""             , ""             },
			{"одном "  , "одной "  , "одиннадцати " , "десяти "      , "ста "         },
			{"двух "   , "двух "   , "двенадцати "  , "двадцати "    , "двухстах "    },
			{"трех "   , "трех "   , "тринадцати "  , "тридцати "    , "трехстах "    },
			{"четырех ", "четырех ", "четырнадцати ", "сорока "      , "четырехстах " },
			{"пяти "   , "пяти "   , "пятнадцати "  , "пятидесяти "  , "пятистах "    },
			{"шести "  , "шести "  , "шестнадцати " , "шестидесяти " , "шестистах "   },
			{"семи "   , "семи "   , "семнадцати "  , "семидесяти "  , "семистах "    },
			{"восьми " , "восьми " , "восемнадцати ", "восьмидесяти ", "восьмистах "  },
			{"девяти " , "девяти " , "девятнадцати ", "девяноста "   , "девятистах "  },
	};
}
