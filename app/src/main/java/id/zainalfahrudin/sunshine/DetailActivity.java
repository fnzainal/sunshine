package id.zainalfahrudin.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zainal on 16/04/16.
 */
public class DetailActivity extends AppCompatActivity {
    private String TAG = "DetailActiivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.container)!=null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new DetailFragment()).commit();
        }
    }

    private class DetailFragment extends Fragment {
        private TextView tvDetail;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater,
                                 @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_detail, null);
            return view;

        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            tvDetail = (TextView)getActivity().findViewById(R.id.tvDetail);
            String stringExtra = "";
            Intent intent = getActivity().getIntent();
            if (intent!=null&&intent.hasExtra(Intent.EXTRA_TEXT)){
                stringExtra = intent.getStringExtra(Intent.EXTRA_TEXT);
                Log.d(TAG, "onCreateView: detail = "+stringExtra);
                tvDetail.setText(stringExtra);
            }
        }
    }
}
