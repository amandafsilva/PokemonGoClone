package amandafsilva.pokemongoclone;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Amanda on 25.04.2017.
 */

public class PokemonGoCloneDB extends SQLiteOpenHelper {

    // Informações do BD
    private static final String NOME_BANCO = "PokemonGoCloneBD.bd";
    private static final int VERSAO_BANCO = 1;

    // Padrão Singleton
    private static Context context;
    private static PokemonGoCloneDB instance;
    private static SQLiteDatabase db;

    public static synchronized PokemonGoCloneDB getInstance(Context context) {
        // Assegura que apenas um PokemonGoCloneDB vai existir em qualquer momento
        // Se instance não tiver sido inicializada, uma será criada
        // Se já existe, então será apenas retornada
        if (instance == null) {
            instance = new PokemonGoCloneDB(context.getApplicationContext());
        }
        return instance;
    }

    public PokemonGoCloneDB(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
        PokemonGoCloneDB.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String[] sql_create = new String[] {
                "CREATE TABLE IF NOT EXISTS pokemon (\n" +
                        "  idPokemon INTEGER PRIMARY KEY,\n" +
                        "  nome TEXT NOT NULL,\n" +
                        "  categoria TEXT NOT NULL,\n" +
                        "  foto INTEGER NOT NULL,\n" +
                        "  icone INTEGER NOT NULL\n" +
                        ");",

                "INSERT INTO pokemon (idPokemon, nome, categoria, foto, icone) VALUES\n" +
                        "(1, 'Bulbasaur', 'I', R.drawable.p1, R.drawable.i1),\n" +
                        "(2, 'Ivysaur', 'I', R.drawable.p2, R.drawable.i2),\n" +
                        "(3, 'Venusaur', 'R', R.drawable.p3, R.drawable.i3),\n" +
                        "(4, 'Charmander', 'I', R.drawable.p4, R.drawable.i4),\n" +
                        "(5, 'Charmeleon', 'I', R.drawable.p5, R.drawable.i5),\n" +
                        "(6, 'Charizard', 'R', R.drawable.p6, R.drawable.i6),\n" +
                        "(7, 'Squirtle', 'I', R.drawable.p7, R.drawable.i7),\n" +
                        "(8, 'Wartortle', 'I', R.drawable.p8, R.drawable.i8),\n" +
                        "(9, 'Blastoise', 'R', R.drawable.p9, R.drawable.i9),\n" +
                        "(10, 'Caterpie', 'C', R.drawable.p10, R.drawable.i10),\n" +
                        "(11, 'Metapod', 'C', R.drawable.p11, R.drawable.i11),\n" +
                        "(12, 'Butterfree', 'I', R.drawable.p12, R.drawable.i12),\n" +
                        "(13, 'Weedle', 'C', R.drawable.p13, R.drawable.i13),\n" +
                        "(14, 'Kakuna', 'C', R.drawable.p14, R.drawable.i14),\n" +
                        "(15, 'Beedrill', 'I', R.drawable.p15, R.drawable.i15),\n" +
                        "(16, 'Pidgey', 'C', R.drawable.p16, R.drawable.i16),\n" +
                        "(17, 'Pidgeotto', 'I', R.drawable.p17, R.drawable.i17),\n" +
                        "(18, 'Pidgeot', 'R', R.drawable.p18, R.drawable.i18),\n" +
                        "(19, 'Rattata', 'C', R.drawable.p19, R.drawable.i19),\n" +
                        "(20, 'Raticate', 'I', R.drawable.p20, R.drawable.i20),\n" +
                        "(21, 'Spearow', 'C', R.drawable.p21, R.drawable.i21),\n" +
                        "(22, 'Fearow', 'I', R.drawable.p22, R.drawable.i22),\n" +
                        "(23, 'Ekans', 'C', R.drawable.p23, R.drawable.i23),\n" +
                        "(24, 'Arbok', 'I', R.drawable.p24, R.drawable.i24),\n" +
                        "(25, 'Pikachu', 'C', R.drawable.p25, R.drawable.i25),\n" +
                        "(26, 'Raichu', 'I', R.drawable.p26, R.drawable.i26),\n" +
                        "(27, 'Sandshrew', 'C', R.drawable.p27, R.drawable.i27),\n" +
                        "(28, 'Sandslash', 'I', R.drawable.p28, R.drawable.i28),\n" +
                        "(29, 'Nidoran Femea', 'C', R.drawable.p29, R.drawable.i29),\n" +
                        "(30, 'Nidorina', 'I', R.drawable.p30, R.drawable.i30),\n" +
                        "(31, 'Nidoqueen', 'R', R.drawable.p31, R.drawable.i31),\n" +
                        "(32, 'Nidoran Macho', 'C', R.drawable.p32, R.drawable.i32),\n" +
                        "(33, 'Nidorino', 'I', R.drawable.p33, R.drawable.i33),\n" +
                        "(34, 'Nidoking', 'R', R.drawable.p34, R.drawable.i34),\n" +
                        "(35, 'Clefairy', 'I', R.drawable.p35, R.drawable.i35),\n" +
                        "(36, 'Clefable', 'R', R.drawable.p36, R.drawable.i36),\n" +
                        "(37, 'Vulpix', 'C', R.drawable.p37, R.drawable.i37),\n" +
                        "(38, 'Ninetales', 'R', R.drawable.p38, R.drawable.i38),\n" +
                        "(39, 'Jigglypuff', 'C', R.drawable.p39, R.drawable.i39),\n" +
                        "(40, 'Wigglytuff', 'R', R.drawable.p40, R.drawable.i40),\n" +
                        "(41, 'Zubat', 'C', R.drawable.p41, R.drawable.i41),\n" +
                        "(42, 'Golbat', 'I', R.drawable.p42, R.drawable.i42),\n" +
                        "(43, 'Oddish', 'C', R.drawable.p43, R.drawable.i43),\n" +
                        "(44, 'Gloom', 'C', R.drawable.p44, R.drawable.i44),\n" +
                        "(45, 'Vileplume', 'I', R.drawable.p45, R.drawable.i45),\n" +
                        "(46, 'Paras', 'C', R.drawable.p46, R.drawable.i46),\n" +
                        "(47, 'Parasect', 'I', R.drawable.p47, R.drawable.i47),\n" +
                        "(48, 'Venonat', 'C', R.drawable.p48, R.drawable.i48),\n" +
                        "(49, 'Venomoth', 'I', R.drawable.p49, R.drawable.i49),\n" +
                        "(50, 'Diglett', 'C', R.drawable.p50, R.drawable.i50),\n" +
                        "(51, 'Dugtrio', 'I', R.drawable.p51, R.drawable.i51),\n" +
                        "(52, 'Meowth', 'C', R.drawable.p52, R.drawable.i52),\n" +
                        "(53, 'Persian', 'I', R.drawable.p53, R.drawable.i53),\n" +
                        "(54, 'Psyduck', 'C', R.drawable.p54, R.drawable.i54),\n" +
                        "(55, 'Golduck', 'I', R.drawable.p55, R.drawable.i55),\n" +
                        "(56, 'Mankey', 'C', R.drawable.p56, R.drawable.i56),\n" +
                        "(57, 'Primeape', 'I', R.drawable.p57, R.drawable.i57),\n" +
                        "(58, 'Growlithe', 'C', R.drawable.p58, R.drawable.i58),\n" +
                        "(59, 'Arcanine', 'R', R.drawable.p59, R.drawable.i59),\n" +
                        "(60, 'Poliwag', 'C', R.drawable.p60, R.drawable.i60),\n" +
                        "(61, 'Poliwhril', 'C', R.drawable.p61, R.drawable.i61),\n" +
                        "(62, 'Poliwrath', 'R', R.drawable.p62, R.drawable.i62),\n" +
                        "(63, 'Abra', 'C', R.drawable.p63, R.drawable.i63),\n" +
                        "(64, 'Kadabra', 'I', R.drawable.p64, R.drawable.i64),\n" +
                        "(65, 'Alakazam', 'R', R.drawable.p65, R.drawable.i65),\n" +
                        "(66, 'Machop', 'C', R.drawable.p66, R.drawable.i66),\n" +
                        "(67, 'Machoke', 'I', R.drawable.p67, R.drawable.i67),\n" +
                        "(68, 'Machamp', 'R', R.drawable.p68, R.drawable.i68),\n" +
                        "(69, 'Bellsprout', 'C', R.drawable.p69, R.drawable.i69),\n" +
                        "(70, 'Weepinbell', 'I', R.drawable.p70, R.drawable.i70),\n" +
                        "(71, 'Victreebel', 'R', R.drawable.p71, R.drawable.i71),\n" +
                        "(72, 'Tentacool', 'C', R.drawable.p72, R.drawable.i72),\n" +
                        "(73, 'Tentacruel', 'I', R.drawable.p73, R.drawable.i73),\n" +
                        "(74, 'Geodude', 'C', R.drawable.p74, R.drawable.i74),\n" +
                        "(75, 'Graveler', 'I', R.drawable.p75, R.drawable.i75),\n" +
                        "(76, 'Golem', 'R', R.drawable.p76, R.drawable.i76),\n" +
                        "(77, 'Ponyta', 'C', R.drawable.p77, R.drawable.i77),\n" +
                        "(78, 'Rapidash', 'I', R.drawable.p78, R.drawable.i78),\n" +
                        "(79, 'Slowpoke', 'C', R.drawable.p79, R.drawable.i79),\n" +
                        "(80, 'Slowbro', 'I', R.drawable.p80, R.drawable.i80),\n" +
                        "(81, 'Magnemite', 'C', R.drawable.p81, R.drawable.i81),\n" +
                        "(82, 'Magneton', 'I', R.drawable.p82, R.drawable.i82),\n" +
                        "(83, 'Farfetch''d', 'C', R.drawable.p83, R.drawable.i83),\n" +
                        "(84, 'Doduo', 'C', R.drawable.p84, R.drawable.i84),\n" +
                        "(85, 'Dodrio', 'I', R.drawable.p85, R.drawable.i85),\n" +
                        "(86, 'Seel', 'C', R.drawable.p86, R.drawable.i86),\n" +
                        "(87, 'Dewgong', 'R', R.drawable.p87, R.drawable.i87),\n" +
                        "(88, 'Grimer', 'C', R.drawable.p88, R.drawable.i88),\n" +
                        "(89, 'Muk', 'R', R.drawable.p89, R.drawable.i89),\n" +
                        "(90, 'Shellder', 'C', R.drawable.p90, R.drawable.i90),\n" +
                        "(91, 'Cloyster', 'R', R.drawable.p91, R.drawable.i91),\n" +
                        "(92, 'Gastly', 'C', R.drawable.p92, R.drawable.i92),\n" +
                        "(93, 'Haunter', 'I', R.drawable.p93, R.drawable.i93),\n" +
                        "(94, 'Gengar', 'R', R.drawable.p94, R.drawable.i94),\n" +
                        "(95, 'Onix', 'C', R.drawable.p95, R.drawable.i95),\n" +
                        "(96, 'Drowzee', 'C', R.drawable.p96, R.drawable.i96),\n" +
                        "(97, 'Hypno', 'I', R.drawable.p97, R.drawable.i97),\n" +
                        "(98, 'Krabby', 'C', R.drawable.p98, R.drawable.i98),\n" +
                        "(99, 'Kingler', 'I', R.drawable.p99, R.drawable.i99),\n" +
                        "(100, 'Voltorb', 'C', R.drawable.p100, R.drawable.i100),\n" +
                        "(101, 'Electrode', 'I', R.drawable.p101, R.drawable.i101),\n" +
                        "(102, 'Exeggcute', 'I', R.drawable.p102, R.drawable.i102),\n" +
                        "(103, 'Exeggutor', 'R', R.drawable.p103, R.drawable.i103),\n" +
                        "(104, 'Cubone', 'C', R.drawable.p104, R.drawable.i104),\n" +
                        "(105, 'Marowak', 'I', R.drawable.p105, R.drawable.i105),\n" +
                        "(106, 'Hitmonlee', 'I', R.drawable.p106, R.drawable.i106),\n" +
                        "(107, 'Hitmonchan', 'I', R.drawable.p107, R.drawable.i107),\n" +
                        "(108, 'Lickitung', 'I', R.drawable.p108, R.drawable.i108),\n" +
                        "(109, 'Koffing', 'C', R.drawable.p109, R.drawable.i109),\n" +
                        "(110, 'Weezing', 'I', R.drawable.p110, R.drawable.i110),\n" +
                        "(111, 'Rhyhorn', 'C', R.drawable.p111, R.drawable.i111),\n" +
                        "(112, 'Rhydon', 'I', R.drawable.p112, R.drawable.i112),\n" +
                        "(113, 'Chansey', 'I', R.drawable.p113, R.drawable.i113),\n" +
                        "(114, 'Tangela', 'I', R.drawable.p114, R.drawable.i114),\n" +
                        "(115, 'Kangaskhan', 'I', R.drawable.p115, R.drawable.i115),\n" +
                        "(116, 'Horsea', 'C', R.drawable.p116, R.drawable.i116),\n" +
                        "(117, 'Seadra', 'I', R.drawable.p117, R.drawable.i117),\n" +
                        "(118, 'Goldeen', 'C', R.drawable.p118, R.drawable.i118),\n" +
                        "(119, 'Seaking', 'I', R.drawable.p119, R.drawable.i119),\n" +
                        "(120, 'Staryu', 'C', R.drawable.p120, R.drawable.i120),\n" +
                        "(121, 'Starmie', 'I', R.drawable.p121, R.drawable.i121),\n" +
                        "(122, 'Mr. Mime', 'I', R.drawable.p122, R.drawable.i122),\n" +
                        "(123, 'Scyther', 'I', R.drawable.p123, R.drawable.i123),\n" +
                        "(124, 'Jynx', 'I', R.drawable.p124, R.drawable.i124),\n" +
                        "(125, 'Electabuzz', 'I', R.drawable.p125, R.drawable.i125),\n" +
                        "(126, 'Magmar', 'I', R.drawable.p126, R.drawable.i126),\n" +
                        "(127, 'Pinsir', 'I', R.drawable.p127, R.drawable.i127),\n" +
                        "(128, 'Tauros', 'I', R.drawable.p128, R.drawable.i128),\n" +
                        "(129, 'Magikarp', 'C', R.drawable.p129, R.drawable.i129),\n" +
                        "(130, 'Gyarados', 'I', R.drawable.p130, R.drawable.i130),\n" +
                        "(131, 'Lapras', 'I', R.drawable.p131, R.drawable.i131),\n" +
                        "(132, 'Ditto', 'I', R.drawable.p132, R.drawable.i132),\n" +
                        "(133, 'Eevee', 'I', R.drawable.p133, R.drawable.i133),\n" +
                        "(134, 'Vaporeon', 'R', R.drawable.p134, R.drawable.i134),\n" +
                        "(135, 'Jolteon', 'R', R.drawable.p135, R.drawable.i135),\n" +
                        "(136, 'Flareon', 'R', R.drawable.p136, R.drawable.i136),\n" +
                        "(137, 'Porygon', 'R', R.drawable.p137, R.drawable.i137),\n" +
                        "(138, 'Omanyte', 'R', R.drawable.p138, R.drawable.i138),\n" +
                        "(139, 'Omastar', 'R', R.drawable.p139, R.drawable.i139),\n" +
                        "(140, 'Kabuto', 'R', R.drawable.p140, R.drawable.i140),\n" +
                        "(141, 'Kabutops', 'R', R.drawable.p141, R.drawable.i141),\n" +
                        "(142, 'Aerodactyl', 'R', R.drawable.p142, R.drawable.i142),\n" +
                        "(143, 'Snorlax', 'I', R.drawable.p143, R.drawable.i143),\n" +
                        "(144, 'Articuno', 'L', R.drawable.p144, R.drawable.i144),\n" +
                        "(145, 'Zapdos', 'L', R.drawable.p145, R.drawable.i145),\n" +
                        "(146, 'Moltres', 'L', R.drawable.p146, R.drawable.i146),\n" +
                        "(147, 'Dratini', 'I', R.drawable.p147, R.drawable.i147),\n" +
                        "(148, 'Dragonair', 'I', R.drawable.p148, R.drawable.i148),\n" +
                        "(149, 'Dragonite', 'R', R.drawable.p149, R.drawable.i149),\n" +
                        "(150, 'Mewtwo', 'L', R.drawable.p150, R.drawable.i150),\n" +
                        "(151, 'Mew', 'L', R.drawable.p151, R.drawable.i151);",

                "CREATE TABLE IF NOT EXISTS tipo (\n" +
                        "  idTipo INTEGER PRIMARY KEY,\n" +
                        "  nome TEXT NOT NULL\n" +
                        ");",

                "INSERT INTO tipo (idTipo, nome) VALUES\n" +
                        "(1, 'Normal'),\n" +
                        "(2, 'Fire'),\n" +
                        "(3, 'Fighting'),\n" +
                        "(4, 'Water'),\n" +
                        "(5, 'Flying'),\n" +
                        "(6, 'Grass'),\n" +
                        "(7, 'Poison'),\n" +
                        "(8, 'Electric'),\n" +
                        "(9, 'Ground'),\n" +
                        "(10, 'Psychic'),\n" +
                        "(11, 'Rock'),\n" +
                        "(12, 'Ice'),\n" +
                        "(13, 'Bug'),\n" +
                        "(14, 'Dragon'),\n" +
                        "(15, 'Ghost'),\n" +
                        "(16, 'Dark'),\n" +
                        "(17, 'Steel'),\n" +
                        "(18, 'Fairy');",

                "CREATE TABLE IF NOT EXISTS pokemontipo (\n" +
                        "  idPokemon INTEGER NOT NULL,\n" +
                        "  idTipo INTEGER NOT NULL,\n" +
                        "  PRIMARY KEY  (idPokemon,idTipo),\n" +
                        "  CONSTRAINT fk_pokemontipo_pokemon FOREIGN KEY (idPokemon) REFERENCES pokemon (idPokemon),\n" +
                        "  CONSTRAINT fk_pokemontipo_tipo FOREIGN KEY (idTipo) REFERENCES tipo (idTipo)\n" +
                        ");",

                "INSERT INTO pokemontipo (idPokemon, idTipo) VALUES\n" +
                        "(16, 1),\n" +
                        "(17, 1),\n" +
                        "(18, 1),\n" +
                        "(19, 1),\n" +
                        "(20, 1),\n" +
                        "(21, 1),\n" +
                        "(22, 1),\n" +
                        "(39, 1),\n" +
                        "(40, 1),\n" +
                        "(52, 1),\n" +
                        "(53, 1),\n" +
                        "(83, 1),\n" +
                        "(84, 1),\n" +
                        "(85, 1),\n" +
                        "(108, 1),\n" +
                        "(113, 1),\n" +
                        "(115, 1),\n" +
                        "(128, 1),\n" +
                        "(132, 1),\n" +
                        "(133, 1),\n" +
                        "(137, 1),\n" +
                        "(143, 1),\n" +
                        "(4, 2),\n" +
                        "(5, 2),\n" +
                        "(6, 2),\n" +
                        "(37, 2),\n" +
                        "(38, 2),\n" +
                        "(58, 2),\n" +
                        "(59, 2),\n" +
                        "(77, 2),\n" +
                        "(78, 2),\n" +
                        "(126, 2),\n" +
                        "(136, 2),\n" +
                        "(146, 2),\n" +
                        "(56, 3),\n" +
                        "(57, 3),\n" +
                        "(62, 3),\n" +
                        "(66, 3),\n" +
                        "(67, 3),\n" +
                        "(68, 3),\n" +
                        "(106, 3),\n" +
                        "(107, 3),\n" +
                        "(7, 4),\n" +
                        "(8, 4),\n" +
                        "(9, 4),\n" +
                        "(54, 4),\n" +
                        "(55, 4),\n" +
                        "(60, 4),\n" +
                        "(61, 4),\n" +
                        "(62, 4),\n" +
                        "(72, 4),\n" +
                        "(73, 4),\n" +
                        "(79, 4),\n" +
                        "(80, 4),\n" +
                        "(86, 4),\n" +
                        "(87, 4),\n" +
                        "(90, 4),\n" +
                        "(91, 4),\n" +
                        "(98, 4),\n" +
                        "(99, 4),\n" +
                        "(116, 4),\n" +
                        "(117, 4),\n" +
                        "(118, 4),\n" +
                        "(119, 4),\n" +
                        "(120, 4),\n" +
                        "(121, 4),\n" +
                        "(129, 4),\n" +
                        "(130, 4),\n" +
                        "(131, 4),\n" +
                        "(134, 4),\n" +
                        "(138, 4),\n" +
                        "(139, 4),\n" +
                        "(140, 4),\n" +
                        "(141, 4),\n" +
                        "(6, 5),\n" +
                        "(12, 5),\n" +
                        "(16, 5),\n" +
                        "(17, 5),\n" +
                        "(18, 5),\n" +
                        "(21, 5),\n" +
                        "(22, 5),\n" +
                        "(41, 5),\n" +
                        "(42, 5),\n" +
                        "(83, 5),\n" +
                        "(84, 5),\n" +
                        "(85, 5),\n" +
                        "(123, 5),\n" +
                        "(130, 5),\n" +
                        "(142, 5),\n" +
                        "(144, 5),\n" +
                        "(145, 5),\n" +
                        "(146, 5),\n" +
                        "(149, 5),\n" +
                        "(1, 6),\n" +
                        "(2, 6),\n" +
                        "(3, 6),\n" +
                        "(43, 6),\n" +
                        "(44, 6),\n" +
                        "(45, 6),\n" +
                        "(46, 6),\n" +
                        "(47, 6),\n" +
                        "(69, 6),\n" +
                        "(70, 6),\n" +
                        "(71, 6),\n" +
                        "(102, 6),\n" +
                        "(103, 6),\n" +
                        "(114, 6),\n" +
                        "(1, 7),\n" +
                        "(2, 7),\n" +
                        "(3, 7),\n" +
                        "(13, 7),\n" +
                        "(14, 7),\n" +
                        "(15, 7),\n" +
                        "(23, 7),\n" +
                        "(24, 7),\n" +
                        "(29, 7),\n" +
                        "(30, 7),\n" +
                        "(31, 7),\n" +
                        "(32, 7),\n" +
                        "(33, 7),\n" +
                        "(34, 7),\n" +
                        "(41, 7),\n" +
                        "(42, 7),\n" +
                        "(43, 7),\n" +
                        "(44, 7),\n" +
                        "(45, 7),\n" +
                        "(48, 7),\n" +
                        "(49, 7),\n" +
                        "(69, 7),\n" +
                        "(70, 7),\n" +
                        "(71, 7),\n" +
                        "(72, 7),\n" +
                        "(73, 7),\n" +
                        "(88, 7),\n" +
                        "(89, 7),\n" +
                        "(92, 7),\n" +
                        "(93, 7),\n" +
                        "(94, 7),\n" +
                        "(109, 7),\n" +
                        "(110, 7),\n" +
                        "(25, 8),\n" +
                        "(26, 8),\n" +
                        "(81, 8),\n" +
                        "(82, 8),\n" +
                        "(100, 8),\n" +
                        "(101, 8),\n" +
                        "(125, 8),\n" +
                        "(135, 8),\n" +
                        "(145, 8),\n" +
                        "(27, 9),\n" +
                        "(28, 9),\n" +
                        "(31, 9),\n" +
                        "(34, 9),\n" +
                        "(50, 9),\n" +
                        "(51, 9),\n" +
                        "(74, 9),\n" +
                        "(75, 9),\n" +
                        "(76, 9),\n" +
                        "(95, 9),\n" +
                        "(104, 9),\n" +
                        "(105, 9),\n" +
                        "(111, 9),\n" +
                        "(112, 9),\n" +
                        "(63, 10),\n" +
                        "(64, 10),\n" +
                        "(65, 10),\n" +
                        "(79, 10),\n" +
                        "(80, 10),\n" +
                        "(96, 10),\n" +
                        "(97, 10),\n" +
                        "(102, 10),\n" +
                        "(103, 10),\n" +
                        "(121, 10),\n" +
                        "(122, 10),\n" +
                        "(124, 10),\n" +
                        "(150, 10),\n" +
                        "(151, 10),\n" +
                        "(74, 11),\n" +
                        "(75, 11),\n" +
                        "(76, 11),\n" +
                        "(95, 11),\n" +
                        "(111, 11),\n" +
                        "(112, 11),\n" +
                        "(138, 11),\n" +
                        "(139, 11),\n" +
                        "(140, 11),\n" +
                        "(141, 11),\n" +
                        "(142, 11),\n" +
                        "(87, 12),\n" +
                        "(91, 12),\n" +
                        "(124, 12),\n" +
                        "(131, 12),\n" +
                        "(144, 12),\n" +
                        "(10, 13),\n" +
                        "(11, 13),\n" +
                        "(12, 13),\n" +
                        "(13, 13),\n" +
                        "(14, 13),\n" +
                        "(15, 13),\n" +
                        "(46, 13),\n" +
                        "(47, 13),\n" +
                        "(48, 13),\n" +
                        "(49, 13),\n" +
                        "(123, 13),\n" +
                        "(127, 13),\n" +
                        "(147, 14),\n" +
                        "(148, 14),\n" +
                        "(149, 14),\n" +
                        "(92, 15),\n" +
                        "(93, 15),\n" +
                        "(94, 15),\n" +
                        "(81, 17),\n" +
                        "(82, 17),\n" +
                        "(35, 18),\n" +
                        "(36, 18),\n" +
                        "(39, 18),\n" +
                        "(40, 18),\n" +
                        "(122, 18);",

                "CREATE TABLE IF NOT EXISTS usuario (\n" +
                        "  login TEXT PRIMARY KEY,\n" +
                        "  senha TEXT NOT NULL,\n" +
                        "  nome TEXT NOT NULL,\n" +
                        "  sexo TEXT NOT NULL,\n" +
                        "  foto TEXT,\n" +
                        "  dtCadastro TEXT NOT NULL,\n" +
                        "  temSessao TEXT NOT NULL\n" +
                        ");",

                "CREATE TABLE IF NOT EXISTS pokemonusuario (\n" +
                        "  login TEXT NOT NULL,\n" +
                        "  idPokemon INTEGER NOT NULL,\n" +
                        "  latitude REAL NOT NULL,\n" +
                        "  longitude REAL NOT NULL,\n" +
                        "  dtCaptura TEXT NOT NULL,\n" +
                        "  PRIMARY KEY  (login,idPokemon,dtCaptura),\n" +
                        "  CONSTRAINT fk_usuariopokemon_login FOREIGN KEY (login) REFERENCES usuario (login),\n" +
                        "  CONSTRAINT fk_usuariopokemon_pokemon FOREIGN KEY (idPokemon) REFERENCES pokemon (idPokemon)\n" +
                        ");"
        };

        for(int i = 0; i < sql_create.length; i++) {
            db.execSQL(sql_create[i]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            String[] sql_drop = new String[] {
                    "DROP TABLE IF EXISTS pokemon",

                    "DROP TABLE IF EXISTS tipo",

                    "DROP TABLE IF EXISTS pokemontipo",

                    "DROP TABLE IF EXISTS usuario",

                    "DROP TABLE IF EXISTS pokemonusuario"
            };

            for(int i = 0; i < sql_drop.length; i++) {
                db.execSQL(sql_drop[i]);
            }

            onCreate(db);
        }
    }

    /**
     * Returns a writable database instance in order not to open and close many
     * SQLiteDatabase objects simultaneously
     *
     * @return a writable instance to SQLiteDatabase
     */
    public SQLiteDatabase getMyWritableDatabase() {
        if ((db == null) || (!db.isOpen())) {
            db = this.getWritableDatabase();
        }

        return db;
    }

    // Executa um SQL
    public void execSQL(String sql) {
        SQLiteDatabase db = getWritableDatabase();

        try {
            db.execSQL(sql);
        } finally {
            db.close();
        }
    }

}

