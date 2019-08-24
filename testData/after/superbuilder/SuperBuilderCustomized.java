public class SuperBuilderCustomized {
	public static class Parent {
		public static abstract class ParentBuilder<C extends Parent, B extends ParentBuilder<C, B>> {
			@SuppressWarnings("all")
			private int field1;
			public B resetToDefault() {
				field1 = 0;
				return self();
			}
			@SuppressWarnings("all")
			protected abstract B self();
			@SuppressWarnings("all")
			public abstract C build();
			@SuppressWarnings("all")
			public B field1(final int field1) {
				this.field1 = field1;
				return self();
			}
			@Override
			@SuppressWarnings("all")
			public String toString() {
				return "SuperBuilderCustomized.Parent.ParentBuilder(field1=" + this.field1 + ")";
			}
		}
		int field1;
		@SuppressWarnings("all")
		private static final class ParentBuilderImpl extends ParentBuilder<Parent, ParentBuilderImpl> {
			@SuppressWarnings("all")
			private ParentBuilderImpl() {
			}
			@Override
			@SuppressWarnings("all")
			protected ParentBuilderImpl self() {
				return this;
			}
			@Override
			@SuppressWarnings("all")
			public Parent build() {
				return new Parent(this);
			}
		}
		@SuppressWarnings("all")
		protected Parent(final ParentBuilder<?, ?> b) {
			this.field1 = b.field1;
		}
		@SuppressWarnings("all")
		public static ParentBuilder<?, ?> builder() {
			return new ParentBuilderImpl();
		}
	}
	public static class Child extends Parent {
		private static final class ChildBuilderImpl extends ChildBuilder<Child, ChildBuilderImpl> {
			@Override
			public Child build() {
				this.resetToDefault();
				return new Child(this);
			}
			@SuppressWarnings("all")
			private ChildBuilderImpl() {
			}
			@Override
			@SuppressWarnings("all")
			protected ChildBuilderImpl self() {
				return this;
			}
		}
		double field2;
		public static ChildBuilder<?, ?> builder() {
			return new ChildBuilderImpl().field2(10.0);
		}
		@SuppressWarnings("all")
		public static abstract class ChildBuilder<C extends Child, B extends ChildBuilder<C, B>> extends Parent.ParentBuilder<C, B> {
			@SuppressWarnings("all")
			private double field2;
			@Override
			@SuppressWarnings("all")
			protected abstract B self();
			@Override
			@SuppressWarnings("all")
			public abstract C build();
			@SuppressWarnings("all")
			public B field2(final double field2) {
				this.field2 = field2;
				return self();
			}
			@Override
			@SuppressWarnings("all")
			public String toString() {
				return "SuperBuilderCustomized.Child.ChildBuilder(super=" + super.toString() + ", field2=" + this.field2 + ")";
			}
		}
		@SuppressWarnings("all")
		protected Child(final ChildBuilder<?, ?> b) {
			super(b);
			this.field2 = b.field2;
		}
	}
	public static void test() {
		Child x = Child.builder().field2(1.0).field1(5).resetToDefault().build();
	}
}