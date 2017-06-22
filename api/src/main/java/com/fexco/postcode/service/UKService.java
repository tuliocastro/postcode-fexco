package com.fexco.postcode.service;

import com.fexco.postcode.constant.PostCoderEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class UKService {

    private Logger logger = LoggerFactory.getLogger(UKService.class);

    private String response = "[{\"summaryline\":\"Hudson Advisors Ireland Limited, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Hudson Advisors Ireland Limited\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"summaryline\":\"Mercer Global Investments, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Mercer Global Investments\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"summaryline\":\"Brown Brothers Harriman Trustee Services Ireland Limited, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Brown Brothers Harriman Trustee Services Ireland Limited\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"summaryline\":\"Extrion Media, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Extrion Media\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"summaryline\":\"Mfxchange Ireland Limited, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Mfxchange Ireland Limited\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"summaryline\":\"Lone Star International, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Lone Star International\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"summaryline\":\"Marsh Financial Services, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Marsh Financial Services\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"summaryline\":\"41 Leeson Street Lower, Dublin 2, D02 R968\",\"number\":\"41\",\"premise\":\"41\",\"street\":\"Leeson Street Lower\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 R968\"},{\"summaryline\":\"28 Hatch Street Lower, Dublin 2, D02 Y328\",\"number\":\"28\",\"premise\":\"28\",\"street\":\"Hatch Street Lower\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 Y328\"},{\"summaryline\":\"24 Luther House, Adelaide Road, Dublin 2, D02 XP21\",\"buildingname\":\"Luther House\",\"number\":\"24\",\"premise\":\"Luther House, 24\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 XP21\"},{\"summaryline\":\"52 Adelaide Road, Dublin 2, D02 A786\",\"number\":\"52\",\"premise\":\"52\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 A786\"},{\"summaryline\":\"51 Adelaide Road, Dublin 2, D02 VX81\",\"number\":\"51\",\"premise\":\"51\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 VX81\"},{\"summaryline\":\"50 Adelaide Road, Dublin 2, D02 RC60\",\"number\":\"50\",\"premise\":\"50\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RC60\"},{\"summaryline\":\"48 Adelaide Road, Dublin 2, D02 K299\",\"number\":\"48\",\"premise\":\"48\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 K299\"},{\"summaryline\":\"45 Adelaide Road, Dublin 2, D02 NY27\",\"number\":\"45\",\"premise\":\"45\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 NY27\"},{\"summaryline\":\"43 Adelaide Road, Dublin 2, D02 DY73\",\"number\":\"43\",\"premise\":\"43\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 DY73\"},{\"summaryline\":\"42 Adelaide Road, Dublin 2, D02 N793\",\"number\":\"42\",\"premise\":\"42\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 N793\"},{\"summaryline\":\"41 Adelaide Road, Dublin 2, D02 EP30\",\"number\":\"41\",\"premise\":\"41\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 EP30\"},{\"summaryline\":\"40 Adelaide Road, Dublin 2, D02 TY39\",\"number\":\"40\",\"premise\":\"40\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 TY39\"},{\"summaryline\":\"39 Adelaide Road, Dublin 2, D02 HT63\",\"number\":\"39\",\"premise\":\"39\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 HT63\"},{\"summaryline\":\"38 Adelaide Road, Dublin 2, D02 XF74\",\"number\":\"38\",\"premise\":\"38\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 XF74\"},{\"summaryline\":\"19 Carsharlton, Harcourt Terrace, Dublin 2, D02 AE97\",\"buildingname\":\"Carsharlton\",\"number\":\"19\",\"premise\":\"Carsharlton, 19\",\"street\":\"Harcourt Terrace\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 AE97\"},{\"summaryline\":\"17 Harcourt Terrace, Dublin 2, D02 AD70\",\"number\":\"17\",\"premise\":\"17\",\"street\":\"Harcourt Terrace\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 AD70\"},{\"summaryline\":\"9 Harcourt Terrace, Dublin 2, D02 F677\",\"number\":\"9\",\"premise\":\"9\",\"street\":\"Harcourt Terrace\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 F677\"},{\"summaryline\":\"8 Harcourt Terrace, Dublin 2, D02 AY66\",\"number\":\"8\",\"premise\":\"8\",\"street\":\"Harcourt Terrace\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 AY66\"},{\"summaryline\":\"5 Harcourt Terrace, Dublin 2, D02 CH56\",\"number\":\"5\",\"premise\":\"5\",\"street\":\"Harcourt Terrace\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 CH56\"},{\"summaryline\":\"4 Harcourt Terrace, Dublin 2, D02 EE33\",\"number\":\"4\",\"premise\":\"4\",\"street\":\"Harcourt Terrace\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 EE33\"},{\"summaryline\":\"2 Harcourt Terrace, Dublin 2, D02 E722\",\"number\":\"2\",\"premise\":\"2\",\"street\":\"Harcourt Terrace\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 E722\"},{\"summaryline\":\"51 Leeson Street Lower, Dublin 2, D02 N230\",\"number\":\"51\",\"premise\":\"51\",\"street\":\"Leeson Street Lower\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 N230\"},{\"summaryline\":\"50 Leeson Street Lower, Dublin 2, D02 XK26\",\"number\":\"50\",\"premise\":\"50\",\"street\":\"Leeson Street Lower\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 XK26\"},{\"summaryline\":\"24 Hatch Place, Dublin 2, D02 C443\",\"number\":\"24\",\"premise\":\"24\",\"street\":\"Hatch Place\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 C443\"},{\"summaryline\":\"37 Symphony House, Adelaide Road, Dublin 2, D02 EW71\",\"buildinggroupname\":\"Symphony House\",\"number\":\"37\",\"premise\":\"37, Symphony House\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 EW71\"},{\"summaryline\":\"38 Symphony House, Adelaide Road, Dublin 2, D02 H327\",\"buildinggroupname\":\"Symphony House\",\"number\":\"38\",\"premise\":\"38, Symphony House\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 H327\"},{\"summaryline\":\"39 Symphony House, Adelaide Road, Dublin 2, D02 PH28\",\"buildinggroupname\":\"Symphony House\",\"number\":\"39\",\"premise\":\"39, Symphony House\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 PH28\"},{\"summaryline\":\"40 Symphony House, Adelaide Road, Dublin 2, D02 PW77\",\"buildinggroupname\":\"Symphony House\",\"number\":\"40\",\"premise\":\"40, Symphony House\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 PW77\"},{\"summaryline\":\"41 Symphony House, Adelaide Road, Dublin 2, D02 EP28\",\"buildinggroupname\":\"Symphony House\",\"number\":\"41\",\"premise\":\"41, Symphony House\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 EP28\"},{\"summaryline\":\"3 Leeson Place, Dublin 2, D02 YV83\",\"number\":\"3\",\"premise\":\"3\",\"street\":\"Leeson Place\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 YV83\"},{\"summaryline\":\"6 Leeson Place, Dublin 2, D02 HV56\",\"number\":\"6\",\"premise\":\"6\",\"street\":\"Leeson Place\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 HV56\"},{\"summaryline\":\"46 Leeson Place, Dublin 2, D02 AE18\",\"number\":\"46\",\"premise\":\"46\",\"street\":\"Leeson Place\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 AE18\"},{\"summaryline\":\"42 Leeson Place, Dublin 2, D02 Y078\",\"number\":\"42\",\"premise\":\"42\",\"street\":\"Leeson Place\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 Y078\"},{\"summaryline\":\"5 Hatch Place, Dublin 2, D02 KF63\",\"number\":\"5\",\"premise\":\"5\",\"street\":\"Hatch Place\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 KF63\"},{\"summaryline\":\"36 Symphony House, Adelaide Road, Dublin 2, D02 PX29\",\"buildinggroupname\":\"Symphony House\",\"number\":\"36\",\"premise\":\"36, Symphony House\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 PX29\"},{\"summaryline\":\"1A Leeson Place, Dublin 2, D02 TR80\",\"number\":\"1A\",\"premise\":\"1A\",\"street\":\"Leeson Place\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 TR80\"},{\"summaryline\":\"43 Leeson Place, Dublin 2, D02 A566\",\"number\":\"43\",\"premise\":\"43\",\"street\":\"Leeson Place\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 A566\"},{\"summaryline\":\"45 Leeson Place, Dublin 2, D02 K889\",\"number\":\"45\",\"premise\":\"45\",\"street\":\"Leeson Place\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 K889\"},{\"summaryline\":\"47 Leeson Place, Dublin 2, D02 X074\",\"number\":\"47\",\"premise\":\"47\",\"street\":\"Leeson Place\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 X074\"},{\"summaryline\":\"27 Hatch Place, Dublin 2, D02 DV26\",\"number\":\"27\",\"premise\":\"27\",\"street\":\"Hatch Place\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 DV26\"},{\"summaryline\":\"6 Hilton Mews, Harcourt Terrace, Dublin 2, D02 AK76\",\"buildinggroupname\":\"Hilton Mews\",\"number\":\"6\",\"premise\":\"6, Hilton Mews\",\"street\":\"Harcourt Terrace\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 AK76\"},{\"summaryline\":\"5 Hilton Mews, Harcourt Terrace, Dublin 2, D02 YY48\",\"buildinggroupname\":\"Hilton Mews\",\"number\":\"5\",\"premise\":\"5, Hilton Mews\",\"street\":\"Harcourt Terrace\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 YY48\"},{\"summaryline\":\"4 Hilton Mews, Harcourt Terrace, Dublin 2, D02 KV59\",\"buildinggroupname\":\"Hilton Mews\",\"number\":\"4\",\"premise\":\"4, Hilton Mews\",\"street\":\"Harcourt Terrace\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 KV59\"},{\"summaryline\":\"3 Hilton Mews, Harcourt Terrace, Dublin 2, D02 XT35\",\"buildinggroupname\":\"Hilton Mews\",\"number\":\"3\",\"premise\":\"3, Hilton Mews\",\"street\":\"Harcourt Terrace\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 XT35\"},{\"summaryline\":\"2 Hilton Mews, Harcourt Terrace, Dublin 2, D02 XH00\",\"buildinggroupname\":\"Hilton Mews\",\"number\":\"2\",\"premise\":\"2, Hilton Mews\",\"street\":\"Harcourt Terrace\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 XH00\"},{\"summaryline\":\"1 Hilton Mews, Harcourt Terrace, Dublin 2, D02 DP79\",\"buildinggroupname\":\"Hilton Mews\",\"number\":\"1\",\"premise\":\"1, Hilton Mews\",\"street\":\"Harcourt Terrace\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 DP79\"},{\"summaryline\":\"4 Leeson Street Upper, Dublin 4, D04 A2W2\",\"number\":\"4\",\"premise\":\"4\",\"street\":\"Leeson Street Upper\",\"posttown\":\"Dublin 4\",\"county\":\"Dublin\",\"postcode\":\"D04 A2W2\"},{\"summaryline\":\"3 Leeson Street Upper, Dublin 4, D04 E4E8\",\"number\":\"3\",\"premise\":\"3\",\"street\":\"Leeson Street Upper\",\"posttown\":\"Dublin 4\",\"county\":\"Dublin\",\"postcode\":\"D04 E4E8\"},{\"summaryline\":\"40B Dartmouth Square East, Ranelagh, Dublin 6, D06 PF88\",\"number\":\"40B\",\"premise\":\"40B\",\"street\":\"Dartmouth Square East\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 PF88\"},{\"summaryline\":\"40A Dartmouth Square East, Ranelagh, Dublin 6, D06 H799\",\"number\":\"40A\",\"premise\":\"40A\",\"street\":\"Dartmouth Square East\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 H799\"},{\"summaryline\":\"43 Dartmouth Square East, Ranelagh, Dublin 6, D06 EV80\",\"number\":\"43\",\"premise\":\"43\",\"street\":\"Dartmouth Square East\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 EV80\"},{\"summaryline\":\"42 Dartmouth Square East, Ranelagh, Dublin 6, D06 FK40\",\"number\":\"42\",\"premise\":\"42\",\"street\":\"Dartmouth Square East\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 FK40\"},{\"summaryline\":\"41 Dartmouth Square East, Ranelagh, Dublin 6, D06 FK85\",\"number\":\"41\",\"premise\":\"41\",\"street\":\"Dartmouth Square East\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 FK85\"},{\"summaryline\":\"40 Dartmouth Square East, Ranelagh, Dublin 6, D06 A091\",\"number\":\"40\",\"premise\":\"40\",\"street\":\"Dartmouth Square East\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 A091\"},{\"summaryline\":\"39 Dartmouth Square East, Ranelagh, Dublin 6, D06 WF66\",\"number\":\"39\",\"premise\":\"39\",\"street\":\"Dartmouth Square East\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 WF66\"},{\"summaryline\":\"37 Dartmouth Square East, Ranelagh, Dublin 6, D06 YK81\",\"number\":\"37\",\"premise\":\"37\",\"street\":\"Dartmouth Square East\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 YK81\"},{\"summaryline\":\"48 Dartmouth Square East, Ranelagh, Dublin 6, D06 NX07\",\"number\":\"48\",\"premise\":\"48\",\"street\":\"Dartmouth Square East\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 NX07\"},{\"summaryline\":\"47 Dartmouth Square East, Ranelagh, Dublin 6, D06 YY89\",\"number\":\"47\",\"premise\":\"47\",\"street\":\"Dartmouth Square East\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 YY89\"},{\"summaryline\":\"46 Dartmouth Square East, Ranelagh, Dublin 6, D06 KC99\",\"number\":\"46\",\"premise\":\"46\",\"street\":\"Dartmouth Square East\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 KC99\"},{\"summaryline\":\"45 Dartmouth Square East, Ranelagh, Dublin 6, D06 NY73\",\"number\":\"45\",\"premise\":\"45\",\"street\":\"Dartmouth Square East\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 NY73\"},{\"summaryline\":\"44 Dartmouth Square East, Ranelagh, Dublin 6, D06 XF95\",\"number\":\"44\",\"premise\":\"44\",\"street\":\"Dartmouth Square East\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 XF95\"},{\"summaryline\":\"36 Dartmouth Square North, Ranelagh, Dublin 6, D06 DT92\",\"number\":\"36\",\"premise\":\"36\",\"street\":\"Dartmouth Square North\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 DT92\"},{\"summaryline\":\"35 Dartmouth Square North, Ranelagh, Dublin 6, D06 XR77\",\"number\":\"35\",\"premise\":\"35\",\"street\":\"Dartmouth Square North\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 XR77\"},{\"summaryline\":\"32 Dartmouth Square North, Ranelagh, Dublin 6, D06 A312\",\"number\":\"32\",\"premise\":\"32\",\"street\":\"Dartmouth Square North\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 A312\"},{\"summaryline\":\"31 Dartmouth Square North, Ranelagh, Dublin 6, D06 HW60\",\"number\":\"31\",\"premise\":\"31\",\"street\":\"Dartmouth Square North\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 HW60\"},{\"summaryline\":\"28 Dartmouth Square North, Ranelagh, Dublin 6, D06 TW14\",\"number\":\"28\",\"premise\":\"28\",\"street\":\"Dartmouth Square North\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 TW14\"},{\"summaryline\":\"27 Dartmouth Square North, Ranelagh, Dublin 6, D06 H720\",\"number\":\"27\",\"premise\":\"27\",\"street\":\"Dartmouth Square North\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 H720\"},{\"summaryline\":\"26 Dartmouth Square North, Ranelagh, Dublin 6, D06 W802\",\"number\":\"26\",\"premise\":\"26\",\"street\":\"Dartmouth Square North\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 W802\"},{\"summaryline\":\"25 Dartmouth Square North, Ranelagh, Dublin 6, D06 RK72\",\"number\":\"25\",\"premise\":\"25\",\"street\":\"Dartmouth Square North\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 RK72\"},{\"summaryline\":\"24 Dartmouth Square North, Ranelagh, Dublin 6, D06 YY93\",\"number\":\"24\",\"premise\":\"24\",\"street\":\"Dartmouth Square North\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 YY93\"},{\"summaryline\":\"23 Dartmouth Square North, Ranelagh, Dublin 6, D06 X090\",\"number\":\"23\",\"premise\":\"23\",\"street\":\"Dartmouth Square North\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 X090\"},{\"summaryline\":\"22 Dartmouth Square North, Ranelagh, Dublin 6, D06 T024\",\"number\":\"22\",\"premise\":\"22\",\"street\":\"Dartmouth Square North\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 T024\"},{\"summaryline\":\"21 Dartmouth Square North, Ranelagh, Dublin 6, D06 HX68\",\"number\":\"21\",\"premise\":\"21\",\"street\":\"Dartmouth Square North\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 HX68\"},{\"summaryline\":\"20 Saint Gabriel, Dartmouth Square North, Ranelagh, Dublin 6, D06 R242\",\"buildingname\":\"Saint Gabriel\",\"number\":\"20\",\"premise\":\"Saint Gabriel, 20\",\"street\":\"Dartmouth Square North\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 R242\"},{\"summaryline\":\"19 Dartmouth Square North, Ranelagh, Dublin 6, D06 NP48\",\"number\":\"19\",\"premise\":\"19\",\"street\":\"Dartmouth Square North\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 NP48\"},{\"summaryline\":\"17 Dartmouth Square West, Ranelagh, Dublin 6, D06 Y977\",\"number\":\"17\",\"premise\":\"17\",\"street\":\"Dartmouth Square West\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 Y977\"},{\"summaryline\":\"16 Dartmouth Square West, Ranelagh, Dublin 6, D06 DR58\",\"number\":\"16\",\"premise\":\"16\",\"street\":\"Dartmouth Square West\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 DR58\"},{\"summaryline\":\"15 Dartmouth Square West, Ranelagh, Dublin 6, D06 R998\",\"number\":\"15\",\"premise\":\"15\",\"street\":\"Dartmouth Square West\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 R998\"},{\"summaryline\":\"14 Dartmouth Square West, Ranelagh, Dublin 6, D06 FY62\",\"number\":\"14\",\"premise\":\"14\",\"street\":\"Dartmouth Square West\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 FY62\"},{\"summaryline\":\"13 Dartmouth Square West, Ranelagh, Dublin 6, D06 RX23\",\"number\":\"13\",\"premise\":\"13\",\"street\":\"Dartmouth Square West\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 RX23\"},{\"summaryline\":\"21 Dartmouth Walk, Ranelagh, Dublin 6, D06 V257\",\"number\":\"21\",\"premise\":\"21\",\"street\":\"Dartmouth Walk\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 V257\"},{\"summaryline\":\"33 Dartmouth Walk, Ranelagh, Dublin 6, D06 TP38\",\"number\":\"33\",\"premise\":\"33\",\"street\":\"Dartmouth Walk\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 TP38\"},{\"summaryline\":\"20 Dartmouth Walk, Ranelagh, Dublin 6, D06 PC65\",\"number\":\"20\",\"premise\":\"20\",\"street\":\"Dartmouth Walk\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 PC65\"},{\"summaryline\":\"24 Dartmouth Walk, Ranelagh, Dublin 6, D06 PW80\",\"number\":\"24\",\"premise\":\"24\",\"street\":\"Dartmouth Walk\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 PW80\"},{\"summaryline\":\"25 Dartmouth Walk, Ranelagh, Dublin 6, D06 H4X9\",\"number\":\"25\",\"premise\":\"25\",\"street\":\"Dartmouth Walk\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 H4X9\"},{\"summaryline\":\"26 Dartmouth Walk, Ranelagh, Dublin 6, D06 HW29\",\"number\":\"26\",\"premise\":\"26\",\"street\":\"Dartmouth Walk\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 HW29\"},{\"summaryline\":\"34 Dartmouth Walk, Ranelagh, Dublin 6, D06 TP44\",\"number\":\"34\",\"premise\":\"34\",\"street\":\"Dartmouth Walk\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 TP44\"},{\"summaryline\":\"39 Warner's Lane, Ranelagh, Dublin 6, D06 R921\",\"number\":\"39\",\"premise\":\"39\",\"street\":\"Warner's Lane\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 R921\"},{\"summaryline\":\"41 Warner's Lane, Ranelagh, Dublin 6, D06 YH50\",\"number\":\"41\",\"premise\":\"41\",\"street\":\"Warner's Lane\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 YH50\"},{\"summaryline\":\"42 Warner's Lane, Ranelagh, Dublin 6, D06 X4E4\",\"number\":\"42\",\"premise\":\"42\",\"street\":\"Warner's Lane\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 X4E4\"},{\"summaryline\":\"46 Warner's Lane, Ranelagh, Dublin 6, D06 R832\",\"number\":\"46\",\"premise\":\"46\",\"street\":\"Warner's Lane\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 R832\"},{\"summaryline\":\"2 Warner's Lane, Ranelagh, Dublin 6, D06 AX82\",\"number\":\"2\",\"premise\":\"2\",\"street\":\"Warner's Lane\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 AX82\"},{\"summaryline\":\"23 Dartmouth Walk, Ranelagh, Dublin 6, D06 XH74\",\"number\":\"23\",\"premise\":\"23\",\"street\":\"Dartmouth Walk\",\"doubledependentlocality\":\"Ranelagh\",\"posttown\":\"Dublin 6\",\"county\":\"Dublin\",\"postcode\":\"D06 XH74\",\"morevalues\":\"true\",\"nextpage\":\"4\",\"totalresults\":\"426\"}]";

    //TODO Try catch
    //TODO Test cache
    //TODO Melhorar a recuperacao de URL
//    @Cacheable(value = "uk_address", key = "{#query, #params}")
    public String findAdresses(String apiKey, String query, Map<String, String> params) {

        logger.info("finding uk address");

        String url = PostCoderEndpoint.BASE + apiKey + PostCoderEndpoint.UK.ADDRESS + query;

//        PremiseResponse[] response = restTemplate.getForObject(url, PremiseResponse[].class, params);

        return response;
    }

}
