package LeetCode;

import java.util.Arrays;

public class Prob344_ReverseString {
	
	public static void main(String args[]) {
		System.out.println(reverseString2("a dal Hamed a stall a bul Huda Genoese a bai Tyra Maritsa an inn a manner Amador a ballad Eugen a lunes Seal Uta Mraz ibises a rcd Lower a daraf Fendig a sop a kakapo Six a zany Urbannai Rok a mabela Derian a gold Donati a tail Gayel Tutt a wait a liana Kelsi a samfoo Ratib a viz tragi a pood an amah an amatol Abu-Bekr a peh Tuonela Cdr a llama Truc APSA Susy Lait Clo Nieberg a pip an elytron Einar a ryke Kolar a nidana Genolla FERA Horeb a brob a typ Surinam Holmen Tupis a kilo Praha Mora moduli Gyas Nemery Belg Acre Modla Weihs a roti Nada a retd Ald Rayne Grimm a pail Upali Brezin Biela Lloyd Nicolle Benil Martainn a loca a pignus Noh Kroll a bet Isaak an ake Kajaani Wenona an isogriv Pool a snag Haydn Ogpu Caetano Albi Binah Susu Sakai a kabob Kai WPB Lalu a fueller Evan an eyecup a sir For a heb-sed a vinyl Lepp Ansilma Hardden Artina Alkoran Garrek caballeros Alsip Ohara Gainor Bodnar Willem an ogre Basir Demus Neda a coryza Jataka Zaneta Maya Seta Cdoba Krebs Aisne Burner Hamsun Most a rump CCR a barih Savona nates Craner Evatt Edla Belak a scud a ruse Case Slavonic a play Piero Karol Yank Isac Sotho Bellew Sorb Daisi Viyella Mozart a claro Aneto Vano Michale Legra Syr Walburga a daw Zebadiah Mana Leor SJD a citadel a metrise a frt an ogle Nero Kavla Caen ACLU a barbut a sei Groscr Foy Harden Kiah a natl USN Caz Agni Tad Deryl Canad Elam a karma Taino Tirol a valet Tiphani Dann a soup Mallina Mientao Buff a ryot a sumo Nama Zapata Myrtie Dreann an alamo an anil Sim a girosol a patin Ruel FDR a reverend a koto paratroops Liv Asur a topman AKC a pol a borage IrGael Ardussi Pos Lim Bme Ismaili Tori Pasadis a novel Sucre Caleb a rockoon a bad a nil Bomu Tatia Hopeh Talos a tuatara a desmid a veil Riane Vins a caracara Borg Adlei a bed Yenisei Latini Kibei Docile Kaila a lav Aili Reni a genre gymsia Maleki Tatman a toom Allah Sansone Loy Nellir Gaye Cadiz Timaru Alina Millian a sozin Blair a moolah a yew a lick Cornew Obeid a snug Odlo Cana Tiga Lyall a petasus Orebro Jamill a subah a knot Sabbat Pitana Towrey abris Senlac a jager a nasute Pain a lido Goulet SRO Jamal a wadi an ord Nusku lire Taira Zenas a maya Rosella Vanir a stannum Roti Munniks Idette Susa Dud Dunson a colic a credo Kaz Akili Meiji Fadil a saki NADH Sadat a moss a butat a goop Suelo Dallin a gram a coda Deer FFI a kaka Morel a wiz Zulu a purse Torelli Demetre Deni Duleba MATS a fatso Cynara Aligarh Pashto Bantam a telegram a cit Tangier a kCi Reede Oates Sumbawa a dir FSR Elata Tonye Sokul a yelp piscinae Cop Yukio an asb a frigger ICC a snell Ewell Heidt Lemal Cyd a remake ScB a tallow an usw a tea Gunn a gaffe Benia Pavla a ben an upset a raid Nedrah PPI Mikol an ana Trevor Roger a malm an air a kinoo Mays Adnah a fete Lynn an abac Rann Espoo Peery tsuba Dantean Ainu Soll UNHCR a bdl an orseille whales BFA a mitra MAA a butanol a vac Scylla Garik a raob a sloop a dram a picul Tawsha Bassett Evanne Daveta Gwenni a shp a restr a weldor a dill a ctg Staw a goad Ludwog a minima Rep Petar Isla Gaige Dean berets a banat Urdu Hereld an anime JFK Dhar a dkg a mace Flood a lasso a tgn a whirr a camoca Reb Omarr a humidor Deena a fife Maribor a rill Fanya Konakri Krenn Oconnor a nom Gad Skirnir Rollin a sirup Moyra Matane Won ASTM ChemE Remy a fytte Had an ergate Lavena Elis Pravda Dom an ait a slab a regr a barege a yaw Obelia Joacima a cfm a tessera Camb Piegari Masao Tao Bealle Dunois SECAM Herse Yetac Sumatra Benoit a coverall a dub a hire Sokoto Gogra a lobo Lati a wadna Guevara Lew Orpah   Comdr    Ibanez  OEM a canal Panama!"));
		String s = "  my name   is  rob";
		s = s.trim();
		System.out.println(Arrays.toString(s.split("[\\s]+")));
	}
	
	public static String reverseString(String s) {
		if (s.length() < 2 || s == null)
			return s;
		String ans = "";
		char[] c = s.toCharArray();
		System.out.println(c.length);
		for (int i = c.length-1; i >= 0; i--) {
			ans += c[i];
		}
		
		return ans;
	}
	
	public static String reverseString2(String s) {
		if(s == null) return null;
		if(s.equals("")) return s;
		
		char [] arrChar = s.toCharArray();
		for(int i = 0, j = arrChar.length - 1; i <= j; i++, j--){
			char temp = arrChar[i];
			arrChar[i] = arrChar[j];
			arrChar[j] = temp;
		}
		
		return new String(arrChar);
	}

}
