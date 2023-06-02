package com.example.rxandroidexample


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.rxandroidexample.databinding.MainActivityBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable




class MainActivity : ComponentActivity() {
    companion object{
        val TAG="MainActivity"
    }

    lateinit var binding:MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        binding.root

        //Create a simple Observable
        val observable = Observable.just(1,2,3,5)

        val observer = object :Observer<Int>{
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe: ${d}")
            }

            override fun onNext(t: Int) {
                Log.d(TAG, "onNext: ${t}")
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "onError: +${e.toString()}")
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete: ")
            }
        }

        observable.subscribe(observer)
    }
}
