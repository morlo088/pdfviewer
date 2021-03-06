package com.seg3525_project.pdfviewer.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.seg3525_project.pdfviewer.models.Book;
import com.seg3525_project.pdfviewer.R;
import com.seg3525_project.pdfviewer.models.Session;
import com.seg3525_project.pdfviewer.models.User;
import com.seg3525_project.pdfviewer.activities.BookInfoActivity;

import java.util.ArrayList;

/**
 * Created by merek on 07/07/16.
 */
public class SearchResultsBookAdapter extends ArrayAdapter<Book> {

    public SearchResultsBookAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Book book = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.search_results_book, parent, false);

        ImageView bookImage = (ImageView) convertView.findViewById(R.id.bookImage);
        TextView bookTitle = (TextView) convertView.findViewById(R.id.bookTitle);
        TextView bookAuthor = (TextView) convertView.findViewById(R.id.bookAuthor);
        TextView bookISBN = (TextView) convertView.findViewById(R.id.bookISBN);
        ImageView addToCart = (ImageView) convertView.findViewById(R.id.addToCart);
        TextView moreInfo = (TextView) convertView.findViewById(R.id.moreInfo);

        bookImage.setImageBitmap(book.getImage());
        bookTitle.setText(book.getTitle());
        bookAuthor.setText("by " + book.getAuthor());
        bookISBN.setText("ISBN: " + book.getISBN());

        addToCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                User user = Session.getInstance().getUser();
                user.addBookToCart(book);
                remove(book);
                Toast.makeText(getContext(), book.getTitle() + " added to cart.", Toast.LENGTH_SHORT).show();
            }

        });

        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), BookInfoActivity.class);
                intent.putExtra("bookID", book.getId());
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }


}


