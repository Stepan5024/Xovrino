package com.stepan.bokarev.pro_cao;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Oblako extends Fragment {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    GalleryAdapter mAdapter;
    RecyclerView mRecyclerView;
    ArrayList<ImageModel> data = new ArrayList<>();

    public static String IMGS[] = {
            "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Грачевский%20парк%2FIMG_20190215_152206.jpg?alt=media&token=08378865-feff-4c8a-ad77-3e5b36f6be7e",
            "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Грачевский%20парк%2FIMG_20190215_153221.jpg?alt=media&token=d099b26d-2fdb-4eda-a3d1-70e0eba598b4",
            "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Грачевский%20парк%2FIMG_20190215_153841.jpg?alt=media&token=49fb05c6-f1a2-466f-85b6-010187ec9888",
            "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Грачевский%20парк%2FIMG_20190215_163926%20(1).jpg?alt=media&token=c1d371e1-ac4e-467c-a67b-8b3a2b3b0784",
            "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Депо%20Ховрино%2F8YrVKvQwKJI.jpg?alt=media&token=a8cf2dc1-14bb-46f0-b037-ab9061ee3a7f",
            "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Депо%20Ховрино%2F9KnFQ8lZCik.jpg?alt=media&token=349b0edb-6980-4140-b7f3-caa10d7ced42",
            "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Депо%20Ховрино%2FWsfHpAEd3qU.jpg?alt=media&token=f37dd3f6-964e-46e5-af14-c15df6969f44",
            "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Дворец%20спорта%20Динамо%2FIMG_20190208_161840.jpg?alt=media&token=431d9eae-cc83-489b-a840-db0bf7f0f372",
            "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Дворец%20спорта%20Динамо%2FIMG_20190208_161931.jpg?alt=media&token=5353cae5-d0d1-4b89-b2e5-6ad792852437",
            "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Дворец%20спорта%20Динамо%2FIMG_20190208_162335.jpg?alt=media&token=8b34e08d-ab77-4aa8-b688-832624bdca4c"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Дворец%20спорта%20Динамо%2FLoIZbeE9V28.jpg?alt=media&token=11a9ed8d-5770-4c53-8c4d-d91696de4fba"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Дворец%20спорта%20Динамо%2Fk8G-_G247OE.jpg?alt=media&token=33e1457f-76ad-4a32-ac71-2e9057d83627"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Дворец%20спорта%20Динамо%2FpJDIVCdeO4I.jpg?alt=media&token=fd34dad4-ede1-4e31-9f75-71cd2bcd3318"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Дворец%20спорта%20Динамо%2F4PPF_91RyP4.jpg?alt=media&token=c295f150-0d27-4214-89a1-eed31f0f5174"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_105930.jpg?alt=media&token=19a4156b-6af1-45bf-b94d-09e319066224"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_110014.jpg?alt=media&token=a30f68e8-f921-4313-aa68-42aaa7acbfa1"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_110122_HDR.jpg?alt=media&token=006ff6c2-4f7d-4d71-8f26-20a2af055115"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_110127.jpg?alt=media&token=5eb910be-4f53-4fef-9591-4f1c626101ef"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_110152.jpg?alt=media&token=78b5aede-15eb-4d96-bf76-f09c9bd6c4f4"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_110157.jpg?alt=media&token=73ed5443-4341-4148-ba7d-cb86c101f64b"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_110528.jpg?alt=media&token=bb4debd5-0157-4d2f-87f5-e21973aeedaf"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_110633.jpg?alt=media&token=69af5c8f-7cb0-42d6-9ebd-f5ea7482d5cc"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_110656.jpg?alt=media&token=f1e0d077-16de-4fe5-a38b-77678fdcb5af"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_110805.jpg?alt=media&token=4f1bd5f0-e820-4d46-9d47-95a8a03c3965"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_110849_HDR.jpg?alt=media&token=3e658632-3a26-492c-9fb3-8f9eee4b6a6b"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_110858.jpg?alt=media&token=457f68f1-b673-456e-8270-af7a585ef98d"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_110902.jpg?alt=media&token=4e5670e5-d078-443c-b792-2c8f457f8a04"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_110906.jpg?alt=media&token=081712db-4706-452f-8067-7eb3d54cec98"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_111705.jpg?alt=media&token=f47f535d-f18b-426a-812b-b8085f7048aa"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/ЦВЛ%20и%20реабилитации%2FIMG_20190202_111729_HDR.jpg?alt=media&token=52445dd7-733b-469e-8b3c-080667c63ad0"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Усадьба%2FAf2KAuE2Wt0.jpg?alt=media&token=ee61c5fd-cdf0-4e95-83a8-5c77d787d97d"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Усадьба%2FhED_J3hROCk.jpg?alt=media&token=9abdb4eb-2770-4066-ad99-4e39ddc67457"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Усадьба%2Fw9_rgOP7kJU.jpg?alt=media&token=809f5b10-8b7d-4c76-9074-664d86eee1c0"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Храм%2012%20апостолов%2FIMG_20190131_155158.jpg?alt=media&token=043ee5f8-cd7b-4273-b260-775f1d19b804"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Храм%2012%20апостолов%2FIMG_20190131_155306.jpg?alt=media&token=9cf50dc3-66b8-428f-a450-f96a7f8b027b"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Храм%2012%20апостолов%2FIMG_20190131_160232.jpg?alt=media&token=d99839e0-c4eb-4a0b-a37e-e5dd40421848"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Храм%2012%20апостолов%2FIMG_20190131_155713.jpg?alt=media&token=f5f7c828-9a6a-4348-a28e-4dfc4d3fe4c0"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Церковь%20иконы%20Божией%20Матери%2FEfiwdzijo4M.jpg?alt=media&token=f26476c8-7e26-4095-88d0-80246c46cd1f",
            "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Церковь%20иконы%20Божией%20Матери%2FLngy3KY1CjA.jpg?alt=media&token=525f9f1f-0ba2-4ac1-bd95-6715bf43cd6c"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Церковь%20иконы%20Божией%20Матери%2FNuGmahlXIWU.jpg?alt=media&token=50724782-1b02-481e-b63e-ce6b92bb0ce6"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Церковь%20иконы%20Божией%20Матери%2FXDgfOr4uIHc.jpg?alt=media&token=2dec769d-2537-4f8b-bd83-a78926a0d81e"
            , "https://firebasestorage.googleapis.com/v0/b/procao.appspot.com/o/Школа%2FANfhXooIviI.jpg?alt=media&token=03b36c4a-e053-4e02-8262-691aa2faf4cc"

    };
    public static String IMTEXT[] = {
            "Могила героев панфиловцев", "Спортивная площадка в парке Грачевка", "Площадка для собак", "Вид на снесенную ХЗБ", "Локомотив из депо Ховрино",
            "Депо Ховрино красной Октябрьской ЖД дороги", "Корова в Ховрино. Николаевская жд дорога", "Дворец спорта Динамо", "Символика на столбах освещеия"
            , "Динамо", "Строительство Дворца Спорта к олимпиаде 80-ых", "Построенный объект", "Митинг Сахарова у ДС Динамо", "Митинг Сахарова у ДС Динамо", "Скульптура девушки в усадьбе М.С.Грачева", "Потолок в усадьбе и чугунные поручни", "Столовая подобна бальному залу", "Люстра в столовой"
            , "Завораживающая красота внутри", "Потолок", "Братская могила на территории", "Посещение 10 февраля 2019", "С другой стороны здания", "Сотрудники на зиму убирают скульптуры в мешки", "Каждую зиму статуи львов и девушек защищены черными мешками", "Шпиль", "Шпиль"
            , "Фасад со сколом", "Вид от беседки", "Вид от беседки", "Историческая фотография усадьбы М.С.Грачева", "Историческая фотография усадьбы М.С.Грачева", "Статуи львов в усадьбе Грачева",
            "Храм 12 Апостолов", "Люстра с 12 Апостолами", "Святыни Храма 12 Апостолов", "Троица"
            , "В годы войны церковь знамения Божьей Матери в Ховрино", "Историческая фотография", "Храм Знамения Божьей Матери в селе Аксинино", "На реставрации", "Школа 159"

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.oblako, container, false);

        for (int i = 0; i < IMGS.length; i++) {

            ImageModel imageModel = new ImageModel();
            imageModel.setName(IMTEXT[i]);
            imageModel.setUrl(IMGS[i]);
            data.add(imageModel);

        }

        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRecyclerView.setHasFixedSize(true);


        mAdapter = new GalleryAdapter(getContext(), data);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(),
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {

                        Intent intent = new Intent(getContext(), DetailActivity.class);
                        intent.putParcelableArrayListExtra("data", data);
                        intent.putExtra("pos", position);
                        getActivity().setTitle(data.get(position).getName());
                        startActivity(intent);

                    }
                }));
        return view;
    }
}
